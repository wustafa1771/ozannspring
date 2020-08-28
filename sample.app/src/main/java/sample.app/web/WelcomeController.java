package sample.app.web;

import java.util.Date;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.service.WelcomeService;


@RestController
public class WelcomeController {

    @Autowired
    protected WelcomeService welcomeService;

    @RequestMapping("/hello")
    public String welcome() {
        System.out.println("in cntroller");
        String den = welcomeService.den();
         return den;

    }

}
