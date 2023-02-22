package in.learnjavaskills.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerComponent 
{
	@KafkaListener(topics = "truck-status-topic", groupId = "truck-status-group")
	void kafkaListener(String data)
	{
		System.out.println("consume message form the truck-staus-topic is " + data);
	}
}
