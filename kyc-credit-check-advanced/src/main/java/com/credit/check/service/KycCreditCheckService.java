package com.credit.check.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.credit.check.exception.KycCreditCheckException;
import com.credit.check.repo.model.KycRequest;
import com.credit.check.repo.model.KycResponse;
import com.credit.check.util.Constants;
import com.credit.check.repo.KycRepoOperations;

@Service
public class KycCreditCheckService {
	
	Log LOGGER = LogFactory.getLog(KycCreditCheckService.class);
	
	@Value("${repo-ops-trigger:true}")
	boolean	repoOpsTrigger;
	
	@Autowired
	KycRepoOperations repoOperations;
	
	

	public KycResponse processKycCreditCheck(String triggerMongoError) throws KycCreditCheckException  
	{
		KycResponse kycResponse = new KycResponse();
		
		try 
		{	
			kycResponse.setBlackListed(false);
			kycResponse.setCreditUsageBad(false);
			kycResponse.setEmploymentBad(false);
			kycResponse.setInterpolConductBad(false);
			kycResponse.setMilitaryTrained(false);
			kycResponse.setRestrictedNational(false);
			kycResponse.setSuspiciousActivity(false);			
		    kycResponse.setBackgroundCheckPass(true);
		    
		    
		    
		    
		    
		    if(repoOpsTrigger)
		    {
		    	LOGGER.info("---- Starting Mongo operations " );
		    	
		    	repoOperations.save(triggerMongoError);
		    	
		    	LOGGER.info("---- Completed Mongo operations " );
		    }
		    
		    
		    
		    
		    
		    
		    return kycResponse;
		     
		} 
		catch (Exception e) 
		{
			LOGGER.error(Constants.ERROR_MSG_KYC_CREDIT_CHECK_PROCESSING_OPER_FAILED + " : " +e.getMessage());
			throw new KycCreditCheckException(Constants.ERROR_MSG_KYC_CREDIT_CHECK_PROCESSING_OPER_FAILED +" - "+ e.getMessage());
		}
	}	
	
}
