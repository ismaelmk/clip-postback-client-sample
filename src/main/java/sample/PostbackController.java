package sample;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@SpringBootApplication
public class PostbackController {

   public static final Logger logger = LoggerFactory.getLogger(PostbackController.class);

   private final AtomicLong counter = new AtomicLong();

   @RequestMapping("/mypostbackendpoint")
    public void processRequest(@RequestBody String payload) {
       logger.info("payload received: {}, {}", counter.incrementAndGet(), payload);    
   }

   public static void main(String[] args) {
        SpringApplication.run(PostbackController.class, args);
    }
}

