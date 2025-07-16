package org.example.masimplementacja.models.uzytkownicy;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Uzytkownik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Imie nie może być puste")
    @NotNull
    @Size(max = 50)
    private String imie;

    @NotBlank(message = "Nazwisko nie może być puste")
    @NotNull
    @Size(max = 50)
    private String nazwisko;



    @NotBlank(message = "Numer telefonu nie może być pusty")
    @NotNull
    @Size(max = 9)
    private String nrTelefonu;


    public Uzytkownik() {
    }

    public Uzytkownik(String imie, String nazwisko, String nrTelefonu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrTelefonu = nrTelefonu;
    }

    public Long getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {

        this.nrTelefonu = nrTelefonu;
    }

    public void setNazwisko(String nazwisko) {

        this.nazwisko = nazwisko;
    }

    public void setImie(String imie) {

        this.imie = imie;
    }

}
