package com.credit.check.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.credit.check.exception.KycCreditCheckException;
import com.credit.check.repo.model.KycResponse;
import com.credit.check.service.KycCreditCheckService;
import com.credit.check.util.Constants;
import com.credit.check.util.ErrorResponse;
import com.credit.check.util.ErrorsUtil;
import com.credit.check.util.MassiveTestString;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.sym.Name;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/credit-check")
public class KycCreditCheckController {

	Log LOGGER = LogFactory.getLog(KycCreditCheckController.class);
	
	@Autowired
	KycCreditCheckService kycAggrSvc;
	
	@Autowired
	ObjectMapper mapper;	
	
	Map massiveMap = new HashMap();
	List massiveList = new ArrayList();
	
	@GetMapping(path = "/advanced") 
	public ResponseEntity<String> creditCheckRoutingTest1(@RequestHeader Map<String, String> headers, 
														  @RequestParam(required = false, name = "triggerHeapMemoryError") String triggerHeapMemoryError,
														  @RequestParam(required = false, name = "triggerMongoError") String triggerMongoError) 
														  throws Exception
	{		
		LOGGER.info("\n---- Kyc Credit Check Advanced creditCheckRoutingTest1 initiated");
		
		//String kafkaTopicName = headers.get("kafka-topic-name");
		String mongoFirstName = headers.get("mongo-first-name");
		
		
		System.out.println("---- Kyc Credit Check Advanced creditCheckRoutingTest1 triggerHeapMemoryError : " + triggerHeapMemoryError);		
		LOGGER.info("---- Kyc Credit Check Advanced creditCheckRoutingTest1 triggerHeapMemoryError " + triggerHeapMemoryError);
		LOGGER.info("---- Kyc Credit Check Advanced creditCheckRoutingTest1 triggerMongoError " + triggerMongoError);
		LOGGER.info("---- Kyc Credit Check Advanced creditCheckRoutingTest1 mongoFirstName " + mongoFirstName);
		
		
		if("Y".equals(triggerHeapMemoryError))
		{    
		   try
		   {

			//--deliberately load this map to simulate Heap overload - Out of memory error			
			System.out.println("---- Creating massiveMap with new Heap objects ");
			
			//while("Y".equals(triggerHeapMemoryError))
			
			  /*			
			   massiveMap.put(UUID.randomUUID().toString(),new MassiveTestString());
			   System.out.println("---- massiveMap  size : "+ massiveMap.size() );
			   getMemoryStats();
			   */
				
			   System.out.println("---- overloading The HeapMemory starts ");			
			   overloadTheHeapMemory();			   
			   System.out.println("---- overloading The HeapMemory ends ");
			   getMemoryStats();
			   System.out.println("---- Heap overloading continue - massiveList new size : " + massiveList.size());
			
			//--trial
				/*
				LOGGER.info("---- Loading heap with massive test string " );
				Constants.GLOBAL_STATIC_HEAP_STORAGE_MAP.put(UUID.randomUUID().toString(), MassiveTestString.getMassiveTestString());
				LOGGER.info("---- Constants.GLOBAL_STATIC_HEAP_STORAGE_MAP  size : "+ Constants.GLOBAL_STATIC_HEAP_STORAGE_MAP.size() );
				System.out.println("---- Constants.GLOBAL_STATIC_HEAP_STORAGE_MAP  size : "+ Constants.GLOBAL_STATIC_HEAP_STORAGE_MAP.size() );
				*/
				
		   }
		   catch(Exception ex)
	      {
		   	ex.printStackTrace();
	      }

			return new ResponseEntity<String>("Heap Insert Success", HttpStatus.OK);
		}
		
		
		ResponseEntity<String> response = processCreditCheck(triggerMongoError);		
		
		LOGGER.info("\n---- Kyc Credit Check Advanced creditCheckRoutingTest1 completed");		
		return response;
	}	
	
	@GetMapping(path = "/report") 
	public ResponseEntity<String> creditCheckRoutingTest2() throws JsonProcessingException
	{		
		LOGGER.info("\n---- GET Kyc Credit Check Advanced creditCheckRoutingTest2 initiated");
		
		ResponseEntity<String> response = processCreditCheck("");
		
		LOGGER.info("\n---- Kyc Credit Check Advanced creditCheckRoutingTest2 completed");		
		return response;
	}
	
	private ResponseEntity<String> processCreditCheck(String triggerMongoError) throws JsonProcessingException
	{		
		KycResponse kycResponse = null;						
		String response = null;
		
		try 
		{		
		 kycResponse = kycAggrSvc.processKycCreditCheck(triggerMongoError);
		}
		catch (KycCreditCheckException e) 
		{
			ErrorResponse errResponse = ErrorsUtil.constructErrorResponse(e.getMessage());
			
			response = mapper.writeValueAsString(errResponse);
			LOGGER.error(Constants.ERROR_MSG_KYC_CREDIT_CHECK_PROCESSING_OPER_FAILED + " : " +e.getMessage());
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
			LOGGER.info(response + "  "+kycResponse.toString());
			
			response = mapper.writeValueAsString(kycResponse);					
			return new ResponseEntity<String>(response, HttpStatus.OK);
	}	
	
	
	
	 public void getMemoryStats() 
	 {
	      Runtime runtime = Runtime.getRuntime();
	      long memoryMax = runtime.maxMemory();
	      long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
	      double memoryUsedPercent = (memoryUsed * 100.0) / memoryMax;
	      
	      System.out.println("---- memoryUsed : " + memoryUsed);
	      System.out.println("---- memoryUsedPercent : " + memoryUsedPercent);
	      System.out.println("---- freeMemory : " + runtime.freeMemory());
	      
	      
	      if (memoryUsedPercent > 70.0)
	      {
	    	  System.out.println("---- memoryUsedPercent over  : " + memoryUsedPercent);
	      }
	      
	   }

     public void overloadTheHeapMemory() throws Exception
       {  
        
 
        int arrSize = 15;  
        //System.out.println("---- Maximum memory " + Runtime.getRuntime().maxMemory());
      	System.out.println("---- Heap overloading started - massiveList current size :  " +massiveList.size());
        long memoryConsumed = 0;  
        try {  


            long[] memoryAllocated = null;    
            //for (int loop = 0; loop < Integer.MAX_VALUE; loop++) {  
            for (int loop = 0; loop < 2; loop++) {

            	 
            	massiveList.add(new String(UUID.randomUUID().toString() + MassiveTestString.getMassiveTestString()));
            	//System.out.println("---- Heap overloading continue - massiveList new size : " + massiveList.size());
            	Thread.sleep(5000);
            	

            	/*
                memoryAllocated = new long[arrSize];  
                memoryAllocated[0] = 0;  
                memoryConsumed += arrSize * Long.SIZE;  
                System.out.println("---- Memory Consumed: " + memoryConsumed);  
                arrSize *= arrSize * 2;  
                Thread.sleep(500);
                */
                
            }  
        } catch (OutOfMemoryError outofMemory) {  
            System.out.println("**** Out Of Memory error occurred");  
            throw outofMemory;  
//	    ex.printStackTrace();
        }  
    }   

}


