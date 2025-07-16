package org.example.masimplementacja.models.uzytkownicy;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Magazynier extends Uzytkownik {

    @NotBlank(message = "E-mail nie może być pusty")
    @NotNull
    @Size(max = 50)
    private String email;

    public Magazynier() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
