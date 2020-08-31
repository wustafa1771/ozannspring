package sample.service.entities;

public class ConversationRequest {

    private double amount;


    private String source;
    private String target;


    public ConversationRequest(String source, String target, double amount) {
        this.source = source;
        this.target = target;
        this.amount = amount;
    }
    public ConversationRequest(){

    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }



}

