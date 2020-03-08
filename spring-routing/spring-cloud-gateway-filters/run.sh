mvn -f gateway-end-service/pom.xml spring-boot:run &

mvn -f gateway-middle-service/pom.xml spring-boot:run &

mvn -f gateway-with-service/pom.xml spring-boot:run &