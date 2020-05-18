package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import app.fileconfig.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class HelloWorld {


    private static final Logger log = LoggerFactory.getLogger(HelloWorld.class);



    public static void main(String arg[]){
        System.out.println("Hello World");
        SpringApplication.run(HelloWorld.class, arg );
    }


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//        return args -> {
//            Quote quote = restTemplate.getForObject(
//                    "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//            log.info(quote.toString());
//            log.info(quote.getType());
//        };
//    }
}
