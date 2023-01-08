package com.messageapp.repositories;

import com.messageapp.model.ReplyMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyMessageRepo extends JpaRepository<ReplyMessage, Integer> {
}
