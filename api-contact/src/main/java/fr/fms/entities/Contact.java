package fr.fms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "T_contacts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String company;  // Exemple de champ supplémentaire
    private String jobTitle; // Exemple de champ supplémentaire
    private String birthday; // Exemple de champ supplémentaire

    // Si tu as besoin d'une relation avec une catégorie pour organiser les contacts, tu peux ajouter ceci :
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Bonus : Envoi de messages entre contacts (si nécessaire)
    @OneToMany(mappedBy = "contact")
    @JsonIgnore
    private List<Message> messages;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
