package com.in28minutes.microservices.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;

@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
	}
	
	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}
}
