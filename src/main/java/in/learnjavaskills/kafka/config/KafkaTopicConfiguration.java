package in.learnjavaskills.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration 
{
	@Bean
	public NewTopic tructstatustopic()
	{
		return TopicBuilder.name("truck-status-topic")
				.partitions(5)
				.replicas(1)
				.build();
	}
}
