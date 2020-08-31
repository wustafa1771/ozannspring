package sample.service.entities;

import javax.persistence.*;

@Entity
@Table(name = "ConversationList")
public class ConversationResponse {
    @Id
    @Column(name="id")
    @GeneratedValue
    private int transationId;

    private String source;
    private String target;
    private double targetAmount;
    private double sourceAmount;
    public void setSource(String source) {
        this.source = source;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public void setTransationId(int transationId) {
        this.transationId = transationId;
    }

    public long getTransationId() {
        return transationId;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    public double getSourceAmount() {
        return sourceAmount;
    }

    public void setSourceAmount(double sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public ConversationResponse(ConversationRequest conversationRequest) {
        this.source=conversationRequest.getSource();
        this.target=conversationRequest.getTarget();
        this.sourceAmount=conversationRequest.getAmount();
    }
    public ConversationResponse (){

    }
    @Override
    public String toString() {
        return "ConversationResponse{" +
                "transationId=" + transationId +
                ", source='" + source + '\'' +
                ", target='" + target + '\'' +
                ", targetAmount=" + targetAmount +
                '}';
    }
}
