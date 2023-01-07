package com.messageapp.facade;

import com.messageapp.enums.Status;
import com.messageapp.model.Customer;
import com.messageapp.model.Employee;
import com.messageapp.model.Message;
import com.messageapp.model.ReplyMessage;
import com.messageapp.repositories.MessageRepo;
import com.messageapp.repositories.ReplyMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class MessageFacade {
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private EmployeeFacade employeeFacade;
    @Autowired
    private CustomerFacade customerFacade;
    @Autowired
    private ReplyMessageRepo replyMessageRepo;
    public Message saveMessageDetails(Message message, int id){
        try{
            Customer c = customerFacade.findById(id);
            message.setCustomer(c);
            message.setStatus(Status.pending);
            message.setDateTime(LocalDateTime.now());
            messageRepo.save(message);
            return message;
        }catch(Exception e){
            throw new RuntimeException(e.getCause());
        }
    }
    public List<Message> getAllMessages(){
        try{
            List<Message> messageList = messageRepo.findAll();
            return messageList;
        }
        catch(Exception e){
            throw new RuntimeException(e.getCause());
        }

    }
    public Message uploadMessageStatus(Message message, int id){
        try{
            Employee e = employeeFacade.findEmployeeById(id);
            message.setEmployee(e);
            message.setStatus(Status.replied);
            messageRepo.save(message);
            return message;
        }catch (Exception e){
            throw new RuntimeException("Error from backend");
        }
    }
    public ReplyMessage saveReplyMessage(ReplyMessage message, int id){
        try{
            Message m = findMessageById(id);
            message.setMessage(m);
            message.setDateTime(LocalDateTime.now());
            replyMessageRepo.save(message);
            return message;
        }catch(Exception e){
            throw new RuntimeException("error from backend");
        }
    }
    public Message findMessageById(int id){
        try{
            Message message = messageRepo.findById(id).get();
            return message;
        }catch (Exception e){
            throw new RuntimeException("error from backend");
        }
    }
    public List<Message> getMessageByOption(String option){
        try{
            List<Message> messageList = messageRepo.findMessageByOption(option);
            return messageList;
        }catch (Exception e){
            throw new RuntimeException("error from backend");
        }

    }
}
