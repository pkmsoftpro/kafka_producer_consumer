package com.dataprovider;

import static java.util.Arrays.asList;

import java.time.Duration;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.SuggestionEngine;

public class MainConsumer {

public static void main(String[] args) throws InterruptedException{
		
		final Logger LOGGER = LoggerFactory.getLogger(Main.class);
		
		
		SuggestionEngine suggestionEngine = new SuggestionEngine();
		
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9093,localhost:9094");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("group.id", "user-tracking-consumer");
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		
		consumer.subscribe(asList("user-tracking"));
		
		while(true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
			
			for(ConsumerRecord<String, String> record : records) {
				suggestionEngine.processSuggestions(record.key(), record.value());
			}
		}
	}
}
