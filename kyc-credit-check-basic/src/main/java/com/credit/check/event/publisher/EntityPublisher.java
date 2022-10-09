package com.credit.check.event.publisher;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

//import com.banknext.customer.mgt.dto.Customer;
import com.banknext.txn.Customer;
import com.banknext.txn.Entity;
import com.credit.check.util.Constants;

@Service
public class EntityPublisher {
	
	@Value("${new-entity-initiated-topic}")
	String entityTxnTopic;
	
	@Value("${bad-entity-initiated-topic}")
	String badEntityTxnTopic;
	
	
	@Autowired
	private KafkaTemplate<String, Entity> entityKafkaTemplate;
	
	Log LOGGER = LogFactory.getLog(EntityPublisher.class);
		
	/*
	 * public void publish(Customer customer) {
	 * customerKafkaTemplate.send(entityTxnTopic, customer);
	 * LOGGER.info("---- Message published - Entity initiated : " +
	 * customer.toString()); }
	 */
	
	/*
	public void publish(Entity entity, String triggerKafkaError) 
	{
		String topicToPublish =  entityTxnTopic;		
		if("Y".equals(triggerKafkaError))//simulate Kafka error/latency
		{
			topicToPublish = badEntityTxnTopic;			
		}
		
		LOGGER.info("---- Got triggerKafkaError " + triggerKafkaError);
		LOGGER.info("---- Publish Topic set to  " + topicToPublish);
		
		entityKafkaTemplate.send(topicToPublish, entity);
		LOGGER.info("---- Message published - Entity initiated : " +  entity.toString());
    }
	*/
	
	
	public void publish(Entity entity, String triggerKafkaError) throws Exception 
	{
		LOGGER.info("---- Message publish task starts ----");
		//final boolean  publishFailed;
		/*
		try 
		{			
		*/
			String topicToPublish =  entityTxnTopic;		
			if("Y".equals(triggerKafkaError))//simulate Kafka error/latency
			{
				topicToPublish = badEntityTxnTopic;			
			}
			
			LOGGER.info("---- Got triggerKafkaError " + triggerKafkaError);
			LOGGER.info("---- Publish Topic set to  " + topicToPublish);
			
			
			
			
			
			//--sync call
			
			LOGGER.info("---- Msg sending intiated ... " );
			/*
			if("Y".equals(triggerKafkaError))
			{	
				Thread.sleep(10000);//simulate Kafka error/latency
			}
			*/	
			LOGGER.info("---- Before sync send");
			SendResult<String,Entity> result = entityKafkaTemplate.send(topicToPublish, entity).get(10000, TimeUnit.MILLISECONDS);	            
			LOGGER.info("---- After sync send");
			
			/*
			 //---- Sync processing - deliberately sync to simulate latency scenario
			try 
			{
				LOGGER.info("---- Before sync send");
	            SendResult<String,Entity> result = entityKafkaTemplate.send(topicToPublish, entity).get(10000, TimeUnit.MILLISECONDS);	            
	            //LOGGER.info("---- Successfully published message - Entity initiated : " +  entity.toString());
	        }
			catch (Exception te) 
			{
				LOGGER.info("**** Failed to publish message - Entity initiated : " +  entity.toString());
				throw te;
	        }			
			LOGGER.info("---- After sync send");
			*/
			
			/*
			LOGGER.info("---- Before sync send");
			
           SendResult<String,Entity> result = entityKafkaTemplate.send(topicToPublish, entity).get(10000, TimeUnit.MILLISECONDS);
           Constants.KAFKA_PUBLISH_RESULT_MAP.put("SUCCESS", "Y");
           
			LOGGER.info("---- After sync send");
			*/
			
			
			
			//--sync call ends
			
			
			
			
			
			
			
			//----  Async processing - to avoid latency issues
			
			/*
			ListenableFuture<SendResult<String, Entity>> resultFuture = entityKafkaTemplate.send(topicToPublish, entity);
			
			LOGGER.info("---- Before Async send");
			resultFuture.addCallback(new ListenableFutureCallback<SendResult<String, Entity>>()				
				{
					@Override
					public void onSuccess(SendResult<String, Entity> result) 
					{
						LOGGER.info("---- Successfully published message - Entity initiated : " +  entity.toString());
						Constants.KAFKA_PUBLISH_RESULT_MAP.put("SUCCESS", "Y");
					}

					@Override
					public void onFailure(Throwable ex) 
					{
						LOGGER.info("**** Failed to publish message - Entity initiated : " +  entity.toString());
						Constants.KAFKA_PUBLISH_RESULT_MAP.put("SUCCESS", "N");
					}
					
				}				
			);
			LOGGER.info("---- After Async send");
			*/
			
		
		LOGGER.info("---- Message publish task ends ");
		
		
    }
	
}