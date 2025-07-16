package org.example.masimplementacja.DTOs;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.masimplementacja.enums.RodzajPaliwa;
import org.example.masimplementacja.repositories.PojazdRepository;

public class PojazdAddDTO {

    private PojazdRepository repo;

    boolean czyIstnieje;
    private Long id;

    @NotBlank(message = "Marka nie może być pusta")
    @Size(max = 20, message = "Marka nie może być dłuższa niż 20 znaków")
    private String marka;

    @NotBlank(message = "Model nie może być pusty")
    @Size(max = 30, message = "Model nie może być dłuższy niż 30 znaków")
    private String model;
    @NotNull(message = "Rodzaj paliwa nie może być pusty")
    @Enumerated(EnumType.STRING)
    private RodzajPaliwa rodzajPaliwa;

    @NotBlank
    @Size(min = 7, max = 8, message = "Numer rejestracyjny musi zawierać od 7 do 8 znaków")
    @Column(nullable = false, unique = true)
    private String numerRejestracyjny;

    public PojazdAddDTO() {
    }

    public boolean isCzyIstnieje() {
        return czyIstnieje;
    }

    public void setCzyIstnieje(boolean czyIstnieje) {
        this.czyIstnieje = czyIstnieje;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }


    // tylko dla sprawdzenia czy pojazd już istnieje w bazie danych
    public void setId(Long id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        if (marka == null || marka.isBlank())
            throw new IllegalArgumentException("Marka nie może być pusta");
        if (marka.length() > 20)
            throw new IllegalArgumentException("Marka jest za długa (max 20 znaków)");

        this.marka = marka;
    }

    public void setModel(String model) {
        if (model == null || model.isBlank())
            throw new IllegalArgumentException("Model nie może być pusty");
        if (marka.length() > 20)
            throw new IllegalArgumentException("Model jest za długi (max 30 znaków)");
        this.model = model;
    }

    public RodzajPaliwa getRodzajPaliwa() {
        return rodzajPaliwa;
    }

    public void setRodzajPaliwa(RodzajPaliwa rodzajPaliwa) {
        if (rodzajPaliwa == null)
            throw new IllegalArgumentException("Rodaj paliwa nie może być pusty");
        this.rodzajPaliwa = rodzajPaliwa;
    }

    public String getNumerRejestracyjny() {
        return numerRejestracyjny;
    }

    public void setNumerRejestracyjny(String numerRejestracyjny) {
        if (numerRejestracyjny == null || numerRejestracyjny.isBlank())
            throw new IllegalArgumentException("Numer rejestracyjny nie może być pusty");
        if (numerRejestracyjny.length() > 8 || numerRejestracyjny.length() < 7)
            throw new IllegalArgumentException("Numer rejestracyjny musi mieć min 7 max 8 znaków");

        this.numerRejestracyjny = numerRejestracyjny;
    }
}
