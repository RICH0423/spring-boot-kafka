# spring-boot-kafka
 
Apache Kafka is an open source project used to publish and subscribe the messages based on the fault-tolerant messaging system. This project shows how to implement the Apache Kafka in Spring Boot application.

## Add the following spring-kafka dependency

```xml
<dependency>
   <groupId>org.springframework.kafka</groupId>
   <artifactId>spring-kafka</artifactId>
   <version>2.1.0.RELEASE</version>
</dependency>
```

## We can then write the producer which uses Spring's KafkaTemplate to send the message to a topic

```java
@Autowired
private KafkaTemplate<String,String> kafkaTemplate;

public void sendMessage(String message){
    log.info("Producing message: {}", message);
    this.kafkaTemplate.send(TOPIC, message);
}
```

## Next, write a @KafkaListener to listen to the messages.

```java
@KafkaListener(topics = "topic", groupId = "group-id")
```

## Then we need to start the Kafka cluster locally before run Spring Boot application.

```console
docker-compose up -d
```

## Finally, run our application and send message to Kafka.

```console
kafka-topics --create --topic message --replication-factor 1  --partitions 1 --zookeeper zookeeper:2181  // create topic

kafka-console-consumer --bootstrap-server kafka:9092 --topic message --from-beginning  // listen message topic

curl -X POST http://localhost:9000/kafka/messages?message=hello  // send request 
```
