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
    private double sourceAmout;
    private double targetAmount;

    public void setSource(String source) {
        this.source = source;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setSourceAmout(double sourceAmout) {
        this.sourceAmout = sourceAmout;
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

    public double getSourceAmout() {
        return sourceAmout;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public ConversationResponse(ConversationRequest conversationRequest) {
        this.source=conversationRequest.getSource();
        this.target=conversationRequest.getTarget();
        this.sourceAmout=conversationRequest.getAmout();
    }
    public ConversationResponse (){

    }
    @Override
    public String toString() {
        return "ConversationResponse{" +
                "transationId=" + transationId +
                ", source='" + source + '\'' +
                ", target='" + target + '\'' +
                ", sourceAmout=" + sourceAmout +
                ", targetAmount=" + targetAmount +
                '}';
    }
}
