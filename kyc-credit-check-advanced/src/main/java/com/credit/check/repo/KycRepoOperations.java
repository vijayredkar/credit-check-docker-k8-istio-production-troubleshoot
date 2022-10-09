package com.credit.check.repo;

import java.sql.Date;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.credit.check.exception.KycCreditCheckException;
import com.credit.check.repo.model.KycRepoData;
import com.credit.check.util.Constants;

@Service
public class KycRepoOperations {
	
	Log LOGGER = LogFactory.getLog(KycRepoOperations.class);
	
	@Autowired
	KycRepository kycRepo;

	public void save(String triggerMongoError) throws KycCreditCheckException  
	{	
		try 
		{	
			
			LOGGER.info("--- triggerMongoError received  " +triggerMongoError);
			
			KycRepoData kycRepoData = new KycRepoData();
			
			//kycRepoData.setId("");
			
			String firstName = null;
			
			/* --  to simulate mongo unique constraint error or happy path Mongo insert */
			if("Y".equals(triggerMongoError))
			{
				firstName = "John";   //duplicate firstname
				//firstName = ObjectUtils.isEmpty(mongoFirstName) ? "John" : mongoFirstName;
			}
			else
			{				
				UUID uuid=UUID.randomUUID(); 
				firstName = uuid.randomUUID().toString().substring(0,10);  //unique firstname
			}
			
			LOGGER.info("--- firstName set to " +firstName);
			
			
			/*--                                                                       */
					
			kycRepoData.setFirstName(firstName);//has unique Id constraint in Mongo
			
			kycRepoData.setCitizenship("USA");
			kycRepoData.setCurrentResidenceCountry("IND");
			kycRepoData.setDateOfBirth(new Date(1000L));			
			kycRepoData.setLastName("Pere");
			kycRepoData.setGender("M");
			kycRepoData.setMaritalStatus("Married");
			kycRepoData.setPassportCountryOfIssue("GB");
			kycRepoData.setPassportExpiryDate(new Date(1000L));
			kycRepoData.setPassportNumber("7763534");
		    
		    //kycRepo.save(kycRepoData);
			kycRepo.insert(kycRepoData); //insert - expected to simulate DB error scenario when firstName already exists
		    
			LOGGER.info("--- Mongo insert success " +kycRepoData);
		     
		} 
		catch (Exception e) 
		{
			LOGGER.error(Constants.ERROR_MSG_KYC_CREDIT_CHECK_MONGO_OPER_FAILED + " : " +e.getMessage());
			throw new KycCreditCheckException(Constants.ERROR_MSG_KYC_CREDIT_CHECK_MONGO_OPER_FAILED +" - "+ e.getMessage());
		}
	}	
	
}
