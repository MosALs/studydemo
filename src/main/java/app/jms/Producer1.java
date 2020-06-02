package app.jms;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer1 {

    @RequestMapping(name = "/produce/{message}" , method = RequestMethod.GET)
    public String produceMessage(@PathVariable String message){




        return "Message : "+message+" produced successfully";
    }
}
