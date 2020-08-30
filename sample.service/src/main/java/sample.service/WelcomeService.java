package sample.service;

import sample.service.entities.ConversationRequest;

public interface WelcomeService {
    double convertCurrency(String source,String target);
    double conversion(ConversationRequest conversationRequest);
}
