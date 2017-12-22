package Simple_Consumer;

import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;



public class Simple_Consumer {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String topicName = sc.nextLine();
		sc.close();
				
		//instanciation de l'objet properties
		Properties props = new Properties ();
		
		//paramétrage des proprietes
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id",  "goupTest");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		
		//instanciation du consumer
		KafkaConsumer <String, String> consumer = new KafkaConsumer<> (props);
		
		//abonnement du consumer au topic
		consumer.subscribe(Arrays.asList(topicName));
		
		try {
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(100);
		         for (ConsumerRecord<String, String> record : records) {
					System.out.printf("offset= %d, key= %s, value= %s\n", record.offset(), record.key(), record.value());
				}
			}
		}
		finally {
			consumer.close();
		}

	}

}

