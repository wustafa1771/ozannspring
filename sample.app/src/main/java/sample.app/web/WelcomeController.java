package sample.app.web;

import java.util.Date;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sample.service.WelcomeService;


@Controller
public class WelcomeController {

    @Autowired
    protected WelcomeService welcomeService;

    @RequestMapping("/hello")
    public String welcome(Map<String, Object> model) {
    return welcomeService.den();

    }

}
