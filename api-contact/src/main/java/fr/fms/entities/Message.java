package fr.fms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;  // Contenu du message
    private LocalDateTime sentDate;  // Date et heure d'envoi du message

    // Relation avec l'utilisateur qui a envoyé le message
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    // Relation avec le contact auquel le message est envoyé
    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;
}
