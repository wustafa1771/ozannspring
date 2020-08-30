package sample.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.service.entities.ConversationResponse;

@Repository
public interface Conversationepository extends JpaRepository<ConversationResponse, Long>{
}


