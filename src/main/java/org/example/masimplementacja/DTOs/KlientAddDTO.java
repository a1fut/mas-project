package org.example.masimplementacja.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KlientAddDTO {
    // do sprawdzania czy klient istnieje
    private Long id;
    private boolean czyIstnieje;

    @NotBlank(message = "Imie nie może być puste")
    @Size(max = 50, message = "Imię nie może być dłuższe niż 50 znaków")
    private String imie;
    @NotBlank(message = "Nazwisko nie może być puste")
    @Size(max = 50, message = "Nazwisko nie może być dłuższe niż 50 znaków")
    private String nazwisko;
    @NotBlank(message = "Numer telefonu nie może być pusty")
    @Size(max = 9, message = "Numer telefonu nie może być dłuższy niż 9 znaków")
    private String nrTelefonu;


    public KlientAddDTO() {
    }

    public boolean isCzyIstnieje() {
        return czyIstnieje;
    }

    public void setCzyIstnieje(boolean czyIstnieje) {
        this.czyIstnieje = czyIstnieje;
    }

    //tylko do sprawdzenia czy klient istnieje w bazie danych
    public void setId(Long id) {
        this.id = id;
    }


    public void setImie(String imie) {
        if (imie == null || imie.isBlank())
            throw new IllegalArgumentException("Imie nie może być puste");
        if (imie.length() > 50)
            throw new IllegalArgumentException("Imie jest za długie (max 50 znaków)");
        this.imie = imie;
    }


    public void setNazwisko(String nazwisko) {
        if (nazwisko == null || nazwisko.isBlank())
            throw new IllegalArgumentException("Nazwisko nie może być puste");
        if (nazwisko.length() > 50)
            throw new IllegalArgumentException("Nazwisko jest za długie (max 50 znaków)");

        this.nazwisko = nazwisko;
    }


    public void setNrTelefonu(String nrTelefonu) {
        if (nrTelefonu == null || nrTelefonu.isBlank())
            throw new IllegalArgumentException("Numer telefonu nie może być pusty");
        if (nazwisko.length() > 50)
            throw new IllegalArgumentException("Numer telefonu jest za długi (max 9 znaków)");

        this.nrTelefonu = nrTelefonu;
    }


    public String getNazwisko() {
        return nazwisko;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public String getImie() {
        return imie;
    }

    public Long getId() {
        return id;
    }
}
