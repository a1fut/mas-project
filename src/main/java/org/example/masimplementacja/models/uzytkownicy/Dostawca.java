package org.example.masimplementacja.models.uzytkownicy;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.masimplementacja.models.zamowienia.Zamowienie;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Dostawca extends Uzytkownik {

    @NotNull
    @NotBlank(message = "Nazwa firmy nie może być pusta")
    @Size(max = 50)
    private String nazwaFirmy;


    @NotNull
    @NotBlank(message = "NIP nie może być pusty")
    @Size(min = 11, max = 11)
    private String nip;

    @NotNull
    @NotBlank(message = "Email nie może być pusty")
    @Size(max = 50)
    private String email;

    //asocjacje

    @OneToMany(mappedBy = "dostawca")
    private Set<Zamowienie> zamowienia = new HashSet<>();


    public Dostawca() {
    }

    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public void setNazwaFirmy(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
