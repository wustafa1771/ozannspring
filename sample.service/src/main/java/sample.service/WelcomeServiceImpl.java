package sample.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeServiceImpl implements WelcomeService {

    public String den(){
        return "hello world";
    }
}
