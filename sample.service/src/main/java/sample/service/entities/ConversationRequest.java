package sample.service.entities;

public class ConversationRequest {
    private long id;

    public ConversationRequest(String source, String target, double amout) {
        this.source = source;
        this.target = target;
        this.amout = amout;
    }

    private String source;
    private String target;
    private double amout;

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

    public double getAmout() {
        return amout;
    }

    public void setAmout(double amout) {
        this.amout = amout;
    }
}
