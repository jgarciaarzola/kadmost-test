## Description
We have 3 projects here. `gateway`, `savings-a` and `savings-b`. 

To run the 3 projects you must have installed Docker, Java 11 and Maven

## Running `gateway`
to run the gateway you must run this command 
```
mvn spring-boot:run
```

## Running `saving-a` and `savings-b`
for both projects the running process is the same

first run this command 
```
mvn clean package
```

Once that command has finished you can run 
```
docker-compose up 
```

you must run the commands above for both services

### Testing the services manually 
run the following curl to get the balance of a 
```
curl --location --request GET 'localhost:8080/savings/a/balance'
```

run the following curl to get the balance of b
```
curl --location --request GET 'localhost:8080/savings/b/balance'
```

to update the balanace of account `a` run the following curl
```
curl --location --request POST 'localhost:8080/savings/a/balance' \
--header 'Content-Type: application/json' \
--data-raw '{
    "amount": 100
}'
```

to update the balanace of `b` run the following curl
```
curl --location --request POST 'localhost:8080/savings/b/balance' \
--header 'Content-Type: application/json' \
--data-raw '{
    "amount": 100
}'
```

## Comments
* scale your API gateway?
To scale the api gateway what i would do, would be to have a loadbalancer at the front of the api gateway, so we can scale de api gateway horizontally by having several instances. For the other microservices i would do excactly the same. We can use kubernets as a load balancer
you can have a look at the image here

![Alt text](kadmost-test.png?raw=true "Scale api gateway")

* monitor uptime so you can sleep at night?
To monitor everything i would use newrelic or datadog. The advantage of new relic is that you have monitor of cpu, memory, response time, throughput and errors out of the box. So we can configure a percentage of errors that we can accept, let's say 0.5% or 1% if we start having more than 1% on errors we send an alert to the call so we can handle the issue. If we use datadog we need to build all the dashboards by ourselves we can do basically the same. The good thing about datadog is that we can build business dashboards so we can send alerts also depending on a business condition




