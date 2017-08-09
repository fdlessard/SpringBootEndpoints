import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class EndpointsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EndpointsApplication.class, args);
    }

    @Data
    @AllArgsConstructor
    class Price {
        String id;
        String description;
    }

    @RestController
    @RequestMapping(value = "/controller1")
    class PriceController1 {

        @GetMapping(value = "/price")
        public Price getPrice() {
            return new Price("id", "Description");
        }
    }

    @RestController
    @RequestMapping(value = "/controller2")
    class PriceController2 {

        @GetMapping(value = "/price")
        public Price getPrice() {
            return new Price("id", "Description");
        }
    }
}

//
// Basically, the goal is to use a different MappingJackson2HttpMessageConverter containing
// a different Jackson ObjectMapper that uses a Jackson MixIn to rename(in the Json) the id to priceId
// in the 2nd Controller.

// What a call to the first controller would do :
//
// http://localhost:8080/controller1/price
//
// {
//        id: "id",
//        description: "Description"
// }

// What a call to the second controller would do :
//
// http://localhost:8080/controller2/price
//
// {
//        priceId: "id",
//        description: "Description"
// }
