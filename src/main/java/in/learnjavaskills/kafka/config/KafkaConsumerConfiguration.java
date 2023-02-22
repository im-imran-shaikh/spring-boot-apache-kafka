package in.learnjavaskills.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;

@Configurable
public class KafkaConsumerConfiguration 
{
	@Value("${spring.kafka.bootstrap-servers}")
	private String booststrapServer;
	

	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory(
			ConsumerFactory<String, String> consumerFactory)
	{
		ConcurrentKafkaListenerContainerFactory<String, String> consurrentKafkaListenerContainerFactory = 
				new ConcurrentKafkaListenerContainerFactory<String, String>();
		consurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory);
		return consurrentKafkaListenerContainerFactory;
	}
	
	@Bean
	public ConsumerFactory<String, String> consumerFactory()
	{
		return new DefaultKafkaConsumerFactory<>(kafkaConsumerPropertySource());
	}
	
	private Map<String, Object> kafkaConsumerPropertySource()
	{
		Map<String, Object> kafkaPropertySource = new HashMap<>();
		kafkaPropertySource.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, booststrapServer);
		kafkaPropertySource.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		kafkaPropertySource.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return kafkaPropertySource;
	}
}
