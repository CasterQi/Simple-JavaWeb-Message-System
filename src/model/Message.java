package model;

public class Message {
    private String note;
    private String senderName;
    private String receiverName;
    private String postTime;
    private String readSign;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getReadSign() {
        return readSign;
    }

    public void setReadSign(String readSign) {
        this.readSign = readSign;
    }

    public Message(String note, String senderName, String receiverName, String postTime, String readSign) {
        this.note = note;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.postTime = postTime;
        this.readSign = readSign;
    }
}
