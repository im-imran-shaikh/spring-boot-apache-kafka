Kafka is an open source developed by the LinkedIn and maintain by the confluent
	

	² How to check Kafka successfully installed into the machine
	Þ  command - kafka-topics.bat

	²  What is Zookeeper
	Þ Zookeeper is an infrastructure management tool for the Kafka, 
	it manage Kafka brokers (in cluster)
	Þ Role of the Zookeeper is it will manage Kafka broker and it will scale up and
	 down as per the requirements.
	→  How many broker are available 
	→  Resiliency is taken care by the zookeeper
	→ which topic is which broker
	→  where will broker replication of the partition will be store
	→  meta data about brokers, topics, partition and the replicas 



	
	► Steps to turn on Zookeeper & Kafka
	
NOTE: Always first launch zookeeper before launching the Kafka because, Kafka
 search the running instancy of the zookeeper and the run on zookeeper
instance.


	² How to turn on zookeeper (start zookeeper)
	Þ command - zookeeper-server-start.bat config\zookeeper.properties

	²  How to turn on Kafka (start Kafka)
	Þ  command - kafka-server-start.bat config\server.properties



	► Steps to turn off Zookeeper & Kafka
	NOTE: The order of turning off the zookeeper and the kafka is first stop the
	 Kafka and then stop the Zookeeper. 
	
	
	²  How to turn on Kafka (start Kafka)
	Þ  command - kafka-server-start.bat config\server.properties

	² How to turn on zookeeper (start zookeeper)
	Þ command - zookeeper-server-start.bat config\zookeeper.properties



	► Topics, Partition & Offset

	► Topics: is a particular stream of data
	
	→ Similar to a table in a database(without the constraints)
	→ You can have an as many as topic as you want
	→ A topic is identified by its name
	→ Topics are split in the partitions, Each partition is ordered &Each message
	Within a partition get an incremental id, called offset.
	
	
	

	NOTE: The place where the data is store  is known as the offset
	
	

	► Topic Example - truck GSP



	² How to create topics
	Þ Command - Kafka-topics --zookeeper 127.0.0.1:2181 --topic first topic 
	--create
	
	
	► Topic & Broker 
	
	→ A Kafka cluster is composed of multiple brokers(servers)
	→ Each brokers are identified with the integer Id and Each brokers contains certain topic partition
	→ After connecting any broker (called a bootstrap broker), you will be connected to the entire cluster. 
	→ A good number to get start broker is 3, but some big cluster have over 100 brokers.
	→ In this example we choose to number broker starting at 100  (arbitrary)
	→ In the server.properties file we can mentioned the broker id and we can override as well.


By Default, Kafka will distribute partitions in all the available brokers.



	► Topic & Replication Factor
	
	→ Topic should more than 1 numbers of copy. (ideally we can have 2 or 3 depend on the how critical data is)
	→ This way we can achieve fault tolerant or resilience, if one broker is down then other broker can serve data. 
	→ Example: Topic A with 2 partitions and replication factor of 2
	→ Replica is created for the partition not for the topics.
	
	

There will be only one leader in the replication scenario, for example let's suppose there are 3 replication of the partitions let's say P1, P2 and P3, then among three partitions it is only possible P1 will be leader and other partitions P2 and P3 will be synch with the P1.





NOTE: In the above diagram, Start mark is the leader.

ISR = In Sync Replica



	► Topic - commands

	→ Create topic with name 
	Þ Command - kafka-topics --bootstrap-server localhost:9092 --topic first_topic --create 

	→ How to list down topic
	Þ Command - kafka-topics --bootstrap-server localhost:9092 --topic first_topic --list

	→ How to create partitions 
	Þ  Command - kafka-topics --bootstrap-server localhost:9092 --topic fourth_topic --create --partitions 3 

	→ How to create replication factor
	Þ  Command - kafka-topics --bootstrap-server localhost:9092 --topic fourth_topic --create --partitions 3 --replication-factor 1

	→ How to describe topic (get details of topic)
	Þ Command - kafka-topics --bootstrap-server localhost:9092 --topic fourth_topic --describe




	→ How to delete topic ?
	Þ Command -  kafka-topics --bootstrap-server localhost:9092 --topic first_topic --delete




	► Produce message into the topic

	Command - kafka-console-producer --broker-list localhost:9092 --topic messagetopic




	► Produce message with the Key

	Command -  kafka-console-producer.bat --broker-list localhost:9092 --topic multipartitiontopic --property parse.key=true --prop
	erty key.separator=-



	► Acknowledge in producer
	
	Command : kafka-console-producer --broker-list localhost:9092 --topic messagetopic --producer-property acks=all






	► If try to push message on topic does not exists





	► Consuming message from topic

Command - kafka-console-consumer --bootstrap-server localhost:9092 --topic messagetopic

Or kafka-console-consumer --bootstrap-server localhost:9092 --topic messagetopic --from-beginning

	► To read all the message

Command - kafka-consumer-groups --bootstrap-server localhost:9092 --describe --group multi-part-group

	► Kafka-consumer-group




LAG = how many offset consumer has not read

	► Consume message of key value pair

Command: kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic multipartitiontopic --property print.key=true -
-property key.separator=- --group key-value-group

Consumer 1



Consumer 2













