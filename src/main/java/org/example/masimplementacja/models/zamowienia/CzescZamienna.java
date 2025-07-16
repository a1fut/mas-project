package org.example.masimplementacja.models.zamowienia;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.example.masimplementacja.models.zlecenie.CzesciPotrzebneDoZlecenia;

import java.util.HashSet;
import java.util.Set;

@Entity
public class CzescZamienna {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank(message = "Kod części nie może być pusty")
    @Size(max = 20)
    private String kodCzesci;

    @Positive
    private double cenaKupna;

    @Positive
    private double cenaSprzedazy;

    //asocjacje

    @OneToMany(mappedBy = "czescZamienna")
    private Set<CzesciPotrzebneDoZlecenia> czesciPotrzebneDoZlecenia = new HashSet<>();

    @OneToMany(mappedBy = "czescZamienna")
    private Set<CzescWMagazynie> czesciWMagazynie = new HashSet<>();

    @OneToMany(mappedBy = "czescZamienna")
    private Set<PozycjaZamowienie> pozycjeZamowien = new HashSet<>();


    public CzescZamienna() {
    }

    public Long getId() {
        return id;
    }

    public String getKodCzesci() {
        return kodCzesci;
    }

    public void setKodCzesci(String kodCzesci) {
        this.kodCzesci = kodCzesci;
    }

    public double getCenaKupna() {
        return cenaKupna;
    }

    public void setCenaKupna(double cenaKupna) {
        this.cenaKupna = cenaKupna;
    }

    public double getCenaSprzedazy() {
        return cenaSprzedazy;
    }

    public void setCenaSprzedazy(double cenaSprzedazy) {
        this.cenaSprzedazy = cenaSprzedazy;
    }

    public Set<CzesciPotrzebneDoZlecenia> getCzesciPotrzebneDoZlecenia() {
        return czesciPotrzebneDoZlecenia;
    }

    public void setCzesciPotrzebneDoZlecenia(Set<CzesciPotrzebneDoZlecenia> czesciPotrzebneDoZlecenia) {
        this.czesciPotrzebneDoZlecenia = czesciPotrzebneDoZlecenia;
    }

    public Set<CzescWMagazynie> getCzesciWMagazynie() {
        return czesciWMagazynie;
    }

    public void setCzesciWMagazynie(Set<CzescWMagazynie> czesciWMagazynie) {
        this.czesciWMagazynie = czesciWMagazynie;
    }

    public Set<PozycjaZamowienie> getPozycjeZamowien() {
        return pozycjeZamowien;
    }

    public void setPozycjeZamowien(Set<PozycjaZamowienie> pozycjeZamowien) {
        this.pozycjeZamowien = pozycjeZamowien;
    }
}
