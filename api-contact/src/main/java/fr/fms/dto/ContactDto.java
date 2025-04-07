package fr.fms.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {
    @NotBlank
    private String firstName;
    private String lastName;
    private String email;
    @NotBlank
    private String phone;
    private String address;
    private String company;  // Exemple de champ supplémentaire
    private String jobTitle; // Exemple de champ supplémentaire
    private String birthday; // Exemple de champ supplémentaire

}
