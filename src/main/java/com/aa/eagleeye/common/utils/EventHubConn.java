package com.aa.eagleeye.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aa.eagleeye.common.config.CommonConfig;
import com.azure.messaging.eventhubs.EventData;
import com.azure.messaging.eventhubs.EventDataBatch;
import com.azure.messaging.eventhubs.EventHubClientBuilder;
import com.azure.messaging.eventhubs.EventHubProducerClient;

@Component
public class EventHubConn {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EventHubConn.class);

	@Autowired
	private CommonConfig commonConfigs;

	public void sendDataToEH(List<String> dataStrList) {
		LOGGER.info("Sending data to Event Hub!");
		publishEvents(dataStrList);
	}

	public void publishEvents(List<String> dataStrList) throws IllegalArgumentException{
		// create a producer client
		LOGGER.info("Create a producer client to send events");
		EventHubProducerClient producer = new EventHubClientBuilder()
				.connectionString(commonConfigs.getEventHubconnectionString(), commonConfigs.getEventHubName())
				.buildProducerClient();

		List<EventData> allEvents = new ArrayList<>();// Arrays.asList(new EventData());
		for (String eachData : dataStrList) {
			allEvents.add(new EventData(eachData));
		}

		// create a batch
		EventDataBatch eventDataBatch = producer.createBatch();
		for (EventData eventData : allEvents) {
			// try to add the event from the array to the batch
			if (!eventDataBatch.tryAdd(eventData)) {
				LOGGER.info("Event Batch full, sending previous data.");
				// if the batch is full, send it and then create a new batch
				producer.send(eventDataBatch);
				LOGGER.info("Existing data sent to Event hub");
				eventDataBatch = producer.createBatch();
				LOGGER.info("Retry adding new data to batch");
				// Try to add that event that couldn't fit before.
				if (!eventDataBatch.tryAdd(eventData)) {
					LOGGER.error("Event too large");
					LOGGER.debug("Event is too large for an empty batch. Max size allowed is " + eventDataBatch.getMaxSizeInBytes());
					throw new IllegalArgumentException(
							"Event is too large for an empty batch. Max size: " + eventDataBatch.getMaxSizeInBytes());
				}
			}
		}
		// send the last batch of remaining events
		if (eventDataBatch.getCount() > 0) {
			producer.send(eventDataBatch);
			LOGGER.info("Data sent to Event hub");
		}
		producer.close();
		LOGGER.debug("Closed producer client instance");
	}

}
