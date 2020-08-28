package sample.service;

import org.springframework.stereotype.Service;

@Service("welcomeService")
public class WelcomeServiceImpl implements WelcomeService {

    public String den(){
        System.out.println("in srevice");

        return "hello world";
    }
}
