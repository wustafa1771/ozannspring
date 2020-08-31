package sample.app.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sample.service.OzanService;
import sample.service.entities.ConversationRequest;
import sample.service.entities.ConversationResponse;

import java.util.List;


@RestController
public class OzanController {

    @Autowired
    protected OzanService ozanService;

    private double sourceCur=100;
    private String source = "USD";
    private String target = "TRY";

    @RequestMapping("/exchangeRate")
    public String welcome(@RequestParam String source, @RequestParam String target) {
        double rate = ozanService.convertCurrency(source,target);
         return "your rate is "+rate;

    }
    @RequestMapping("/conversion")
    public String convert(@RequestBody ConversationRequest conversationRequest){
       // ConversationRequest conversationRequest = new ConversationRequest(source,target,100);
        ConversationResponse exrate =ozanService.conversion(conversationRequest);

        return "success ex rate is -- > "+exrate.toString();
    }
    @RequestMapping("/list")
    public String getList(@RequestBody ConversationRequest conversationRequest){
        List<ConversationResponse> i = ozanService.getConversionList(conversationRequest);
        return  "list is "+i;
    }
}
