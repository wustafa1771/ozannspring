package sample.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.orm.jpa.EntityScan;
@SpringBootApplication
public class SampleSpringApp
{
    public static void main(String[] args) {
        SpringApplication.run(SampleSpringApp.class, args);

    }
}
