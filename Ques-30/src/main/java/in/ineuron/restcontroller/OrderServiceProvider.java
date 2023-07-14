package in.ineuron.restcontroller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/api/order")
public class OrderServiceProvider {


    @GetMapping("/another")
    @HystrixCommand(fallbackMethod = "anotherFallBack")
    public String anotherMethod() {
        System.out.println("OrderServiceProvider.anotherMethod()");

      //  let's generate a random number between 1 and 10
        int randomNumber = new Random().nextInt(10) + 1;

        // Return a response based on the random number
        if (randomNumber % 0 == 0) {
            return "Even number generated: " + randomNumber;
        } else {
            return "Odd number generated: " + randomNumber;
        }
    }


    public String anotherFallBack() {
        System.out.println("OrderServiceProvider.anotherFallBack()");
        return "From FallBack Method";
    }
}

