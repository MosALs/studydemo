package app.jms;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer1 {

    /*
     * URL of the JMS server. DEFAULT_BROKER_URL will just mean that JMS server is on localhost
     *
     * default broker URL is : tcp://localhost:61616"
     */
//    private static String url = ActiveMQ.DEFAULT_BROKER_URL;

    @RequestMapping(name = "/produce/{message}" , method = RequestMethod.GET)
    public String produceMessage(@PathVariable String message){



        return "Message : "+message+" produced successfully";
    }
}
