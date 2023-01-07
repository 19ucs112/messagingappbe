package com.messageapp.repositories;

import com.messageapp.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface MessageRepo extends JpaRepository<Message, Integer> {
    @Query(value = "SELECT * FROM message WHERE status=:s",nativeQuery = true)
    public List<Message> findMessageByOption(@Param("s") String option);
}
