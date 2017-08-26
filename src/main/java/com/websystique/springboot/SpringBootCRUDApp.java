package com.websystique.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootCRUDApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootCRUDApp.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootCRUDApp.class, args);
    }

}

//@Import(JpaConfiguration.class)
//@SpringBootApplication(scanBasePackages={"com.websystique.springboot"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
//public class SpringBootCRUDApp {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringBootCRUDApp.class, args);
//	}
//}
