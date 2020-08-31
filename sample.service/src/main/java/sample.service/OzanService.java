package sample.service;

import sample.service.entities.ConversationRequest;
import sample.service.entities.ConversationResponse;

import java.util.List;

public interface OzanService {
    double convertCurrency(String source,String target);
    ConversationResponse conversion(ConversationRequest conversationRequest);
    public List<ConversationResponse> getConversionList(ConversationRequest conversationRequest);
}
