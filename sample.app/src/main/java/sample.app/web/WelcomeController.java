package sample.app.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.service.WelcomeService;
import sample.service.entities.ConversationRequest;


@RestController
public class WelcomeController {

    @Autowired
    protected WelcomeService welcomeService;

    private double sourceCur=100;
    private String source = "USD";
    private String target = "TRY";

    @RequestMapping("/hello")
    public String welcome() {
        System.out.println("in cntroller");
        double rate = welcomeService.convertCurrency("TRY","USD");
         return "your rate is "+rate;

    }
    @RequestMapping("/conversion")
    public String convert(){
        ConversationRequest conversationRequest = new ConversationRequest(source,target,100);
        double exrate =welcomeService.conversion(conversationRequest);
        return "success ex rate is -- > "+exrate;
    }

}
