package in.learnjavaskills.kafka;

import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}
	
	@Bean
	CommandLineRunner produceMessageToTopic(KafkaTemplate<String, String> kafkaTemplate)
	{
		return argument -> {
			IntStream.iterate(1_00_001, increment -> increment + 1)
			.limit(10)
			.forEach(number -> {
				
				ListenableFuture<SendResult<String, String>> future = 
						kafkaTemplate.send("truck-status-topic", "KEY_" + number , " producing messaging topic in key value pair"); 
				
				future.addCallback(new KafkaSendCallback<String, String>() {

					@Override
					public void onSuccess(SendResult<String, String> result) {
						System.out.println("succes fully produce " + number);
						
					}


					@Override
					public void onFailure(KafkaProducerException ex) {
						// TODO Auto-generated method stub
						System.out.println("fail");
					}
					
				});
			});
		};
	}
	
	

}
