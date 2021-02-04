package com.nonave.dockerspringnetflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;



@EnableEurekaServer
@SpringBootApplication
public class DockerSpringNetflixEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerSpringNetflixEurekaServerApplication.class, args);
	}
	
	private static void info(){
		System.out.println("Only test blue Ocean");
	}

}
