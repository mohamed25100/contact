package fr.fms.dao;

import fr.fms.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    // You can add custom queries here if needed
}
