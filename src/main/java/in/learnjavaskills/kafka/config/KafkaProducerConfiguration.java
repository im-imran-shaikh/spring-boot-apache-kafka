package in.learnjavaskills.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configurable
public class KafkaProducerConfiguration 
{
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServer;
	
	
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory)
	{
		return new KafkaTemplate<>(producerFactory);
	}
	
	@Bean
	public ProducerFactory<String, String> producerFactory()
	{
		return new DefaultKafkaProducerFactory<String, String>(producerConfigSource());
	}
	
	
	private Map<String, Object> producerConfigSource()
	{
		Map<String, Object> producerConfigSourceMap = new HashMap<String, Object>();
		producerConfigSourceMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		producerConfigSourceMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerConfigSourceMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return producerConfigSourceMap;
	}
}
