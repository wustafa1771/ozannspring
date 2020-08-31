package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import sample.service.entities.ConversationResponse;

import java.util.List;

@Repository
public interface Conversationepository extends JpaRepository<ConversationResponse, Long>{
}


