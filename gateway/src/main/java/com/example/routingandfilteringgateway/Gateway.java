package com.example.routingandfilteringgateway;

import com.example.routingandfilteringgateway.filters.pre.LogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class Gateway {

	public static void main(String[] args) {
		SpringApplication.run(Gateway.class, args);
	}

	@Bean
	public LogFilter simpleFilter() {
		return new LogFilter();
	}


}
