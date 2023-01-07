package com.messageapp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "replymessage")
public class ReplyMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String repliedMessage;
    @ManyToOne
    private Message message;
    private LocalDateTime dateTime;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRepliedMessage() {
        return repliedMessage;
    }

    public void setRepliedMessage(String repliedMessage) {
        this.repliedMessage = repliedMessage;
    }

    public Message getMessage() {
        return message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
