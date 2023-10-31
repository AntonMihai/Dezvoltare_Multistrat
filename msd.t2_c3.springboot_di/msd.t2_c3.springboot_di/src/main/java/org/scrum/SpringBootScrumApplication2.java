package org.scrum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



import java.util.logging.Logger;
@SpringBootApplication
public class SpringBootScrumApplication2 extends SpringBootServletInitializer{
    private static Logger logger = Logger.getLogger(SpringBootScrumApplication2.class.getName());
    public static void main(String[] args) {
        logger.info("Loading ... :: SpringBoot - ScrumApplication Default Settings ...  ");
        SpringApplication.run(SpringBootScrumApplication2.class, args);
    }
}
