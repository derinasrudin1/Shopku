package com.example.shopku.message;

public class MessageInbox {
    private String senderName;
    private String messageContent;
    private int imageSender;
    private String messageDate;

    public MessageInbox(int imageSender,String senderName, String messageContent, String messageDate ) {
        this.senderName = senderName;
        this.messageContent = messageContent;
        this.imageSender = imageSender;
        this.messageDate = messageDate;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getMessageContent() {
        return messageContent;
    }
    public String getMessageDate() {
        return messageDate;
    }

    public int getImageSender() {
        return imageSender;
    }
}
