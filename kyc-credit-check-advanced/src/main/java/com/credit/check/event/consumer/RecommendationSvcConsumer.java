package com.credit.check.event.consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.banknext.txn.Entity;


@Component

public class RecommendationSvcConsumer {
		
	Log LOGGER = LogFactory.getLog(RecommendationSvcConsumer.class);
	
	@KafkaListener(topics = "${new_entity_initiated_topic}")
    public void listen(Entity entity)
    {        
    	LOGGER.info("---- Message consumed - New Customer-Account created : "+ entity.toString());    	
    	processMessage(entity);
    }

	private void processMessage(Entity entity) {
		recommend(entity);
	}

	private void recommend(Entity entity) {		
		LOGGER.info("---- Recommendation - Customer-Account " + entity.toString());
	}
}
