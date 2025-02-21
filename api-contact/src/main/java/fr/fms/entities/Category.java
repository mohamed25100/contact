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
@Table(name = "T_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;  // Nom de la catégorie (ex. : Personnel, Professionnel)

    // Si tu souhaites avoir une relation avec des contacts dans cette catégorie, tu peux ajouter ceci :
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Contact> contacts;
}
