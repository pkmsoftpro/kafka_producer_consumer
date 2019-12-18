# kafka_producer_consumer
Kafka project, SuggestionEngine

For Windows:

Start Zookeeper and the Kafka Brokers 1 and 2. Publish a TOPIC, as suggested

C:\kafka_2.12-2.3.1>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

C:\kafka_2.12-2.3.1>.\bin\windows\kafka-server-start.bat .\config\server-1.properties

C:\kafka_2.12-2.3.1>.\bin\windows\kafka-server-start.bat .\config\server-2.properties

C:\kafka_2.12-2.3.1>.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9093 --partitions 2 --replication-factor 2 --topic user-tracking

C:\kafka_2.12-2.3.1>.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9093