#### BUILD SPRING JAR

```bash
mvn package -Dmaven.test.skip=true
```

#### CREATE CUSTOM DOCKER NETWORK

```bash
docker network create --driver bridge odknetkafka
```

#### BUILD SPRING DOCKER

```bash
docker build --file=Dockerfile --tag=odk-avro:latest --rm=true .
```

#### RUNNING DOCKER

```bash
docker-compose up -d
```

#### RUNNING CONNECTOR

```bash
curl -X POST -H "Content-Type: application/json" -d @register-postgres.json http://192.168.99.100:8083/connectors
```

OR

```bash
curl -X POST -H "Content-Type: application/json" -d @register-postgres.json http://localhost:8083/connectors
```

#### LIST ALL AVAILABLE TOPICS

```bash
docker-compose exec kafka kafka-topics --zookeeper zookeeper:2181 --list
```

#### REMOVE ALL IMAGES

```bash
docker-compose down --remove-orphans
```
