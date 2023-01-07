package com.messageapp.contoller.message;

import com.messageapp.enums.Status;
import com.messageapp.facade.CustomerFacade;
import com.messageapp.facade.EmployeeFacade;
import com.messageapp.facade.MessageFacade;
import com.messageapp.model.Customer;
import com.messageapp.model.Employee;
import com.messageapp.model.Message;
import com.messageapp.model.ReplyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/message")
@CrossOrigin(origins = {"http://localhost:3000/"})
public class MessageController {
    @Autowired
    private MessageFacade messageFacade;
    @Autowired
    private CustomerFacade customerFacade;
    @Autowired
    private EmployeeFacade employeefacade;
    @PostMapping("/saveMessage/{id}")
    public ResponseEntity<Message> saveMessageDetails(@RequestBody Message message, @PathVariable int id){
        messageFacade.saveMessageDetails(message,id);
        return ResponseEntity.ok().body(message);
    }
    @GetMapping("/getallmessages")
    public ResponseEntity<List<Message>> getAllMessages(){
        List<Message> messageList = messageFacade.getAllMessages();
        return ResponseEntity.ok().body(messageList);
    }
    @PutMapping("/updatemessagestatus/{id}")
    public ResponseEntity<Message> updateMessageStatus(@RequestBody Message message,@PathVariable int id){
        messageFacade.uploadMessageStatus(message, id);
        return ResponseEntity.ok().body(message);
    }
    @PostMapping("/savereplymessage/{id}")
    public ResponseEntity<ReplyMessage> saveReplyMessage(@RequestBody ReplyMessage replyMessage,@PathVariable int id){
        messageFacade.saveReplyMessage(replyMessage, id);
        return ResponseEntity.ok().body(replyMessage);
    }
    @GetMapping("/getmessagesbyoption/{option}")
    public ResponseEntity<List<Message>> getMessageByOption(@PathVariable String option){
        List<Message> messageList = messageFacade.getMessageByOption(option);
        return ResponseEntity.ok().body(messageList);
    }
}
