package eu.papenhagen.spingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpingdemoApplication {

	public static void main(String[] args) {
            ConfigurableApplicationContext appContext = SpringApplication.run(SpingdemoApplication.class, args);
            GreetingImpl greeting = appContext.getBean(GreetingImpl.class);
            System.out.println("" + greeting.greeting("World"));                
	}

}

