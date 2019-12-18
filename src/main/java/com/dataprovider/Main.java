package com.dataprovider;

import static java.lang.Thread.sleep;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Event;
import com.model.EventGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
	
	public static void main(String[] args) throws InterruptedException{
		
		final Logger LOGGER = LoggerFactory.getLogger(Main.class);
		
		
		EventGenerator eventGenerator = new EventGenerator();
		
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9093,localhost:9094");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		Producer<String, String> producer = new KafkaProducer<String, String>(props);
		
		for(int i=1; i<=1000; i++) {
			log.info("Generating event #" + i);
			
			Event event = eventGenerator.generateEvent();
			
			String key = extractKey(event);
			String value = extractValue(event);
			
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("user-tracking", key, value);
			LOGGER.info("producing to Kafka the record: " + key + ":" + value);
			producer.send(producerRecord);
			
			sleep(1000);
		}
		producer.close();
	}

	private static String extractValue(Event event) {
		return event.getUser().getUserId().toString();
	}

	private static String extractKey(Event event) {
		return String.format("%s,%s,%s", event.getProduct().getType(), event.getProduct().getColor(), event.getProduct().getDesignType());
	}
}
