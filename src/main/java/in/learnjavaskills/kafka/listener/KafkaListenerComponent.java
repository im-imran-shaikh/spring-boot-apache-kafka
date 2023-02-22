package in.learnjavaskills.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerComponent 
{
	@KafkaListener(topics = "truck-status-topic", groupId = "truck-status-group")
	void kafkaListener(@Payload String value, 
			@Header(name = KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
			@Header(name = KafkaHeaders.RECEIVED_PARTITION_ID) int partitionId,
			@Header(name = KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(name = KafkaHeaders.OFFSET) int offset)
	{
		System.out.println("consume message form the truck-staus-topic using header and payload \n " 
				+ " key is " + key + " \n"
				+ " value is " + value + " \n"
				+ " partitionId is " + partitionId + " \n"
				+ " topic is " + topic + " \n"
				+ " offset is " + offset
				);
		
		System.out.println(" \n\n\n" + "-------------------------------" + " \n\n\n");
	}
	
	
	@KafkaListener(topics = "truck-status-topic", groupId = "truck-status-group")
	void kafalListerUsingConsumerRecordMetaDeta(String value, ConsumerRecordMetadata metadata)
	{
		System.out.println("consuming message topic using consumer record meta data \n " 
				+ " value " + value + " \n"
				+ " partition " + metadata.partition()  + " \n"
				+ " topic " + metadata.topic() + " \n"
				+ " timestamp " + metadata.timestamp()
				);
		
		System.out.println(" \n\n\n" + "-------------------------------" + " \n\n\n");
	}
}
