package com.credit.check.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banknext.txn.Account;
import com.banknext.txn.Customer;
import com.banknext.txn.Entity;
import com.credit.check.event.publisher.EntityPublisher;
import com.credit.check.exception.KycCreditCheckException;
import com.credit.check.repo.model.KycResponse;
import com.credit.check.util.Constants;

@Service
public class KycCreditCheckService {
	

	@Autowired
	EntityPublisher eventTxnPub;
	
	Log LOGGER = LogFactory.getLog(KycCreditCheckService.class);

	public KycResponse processKycCreditCheck() throws KycCreditCheckException  
	{
		KycResponse kycResponse = new KycResponse();
		
		try 
		{	
			kycResponse.setBlackListed(false);			
		    kycResponse.setBackgroundCheckPass(true);
		    
		    return kycResponse;
		     
		} 
		catch (Exception e) 
		{
			LOGGER.error(Constants.ERROR_MSG_KYC_CREDIT_CHECK_PROCESSING_OPER_FAILED + " : " +e.getMessage());
			throw new KycCreditCheckException(Constants.ERROR_MSG_KYC_CREDIT_CHECK_PROCESSING_OPER_FAILED +" - "+ e.getMessage());
		}
	}	
	
	public void publishEvent(String triggerKafkaError) throws Exception
	{	
		Entity entity = new Entity();
		
		Customer customer = new Customer();
		customer.setCitizenship("USA");
		customer.setEmail("abc@xyz.com");
		customer.setFirstName("Peter");
		customer.setLastName("Rick");
		customer.setOccupation("Engineer");
		entity.setCustomer(customer);
		

		Account account = new Account();
		account.setAccountNum(456743);
		account.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
		account.setDailyWithdrwalLimit(new BigDecimal(5000));
		account.setEnabled(true);
		account.setHni(true);
		account.setMinBalance(new BigDecimal(100));
		account.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
		account.setOverdraft(true);
		account.setType("CUSTOMER");		
		entity.setAccount(account);
		
		LOGGER.info("---- Publishing entity : "+ entity.toString());
		
		eventTxnPub.publish(entity, triggerKafkaError);
	}
}
