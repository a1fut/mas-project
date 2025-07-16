package org.example.masimplementacja.models.zamowienia;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Magazyn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank(message = "Lokalizacja nie może być pusta")
    @Size(max = 25)
    private String lokalizacja;


    //asocjacje

    @OneToMany(mappedBy = "magazyn")
    private Set<CzescWMagazynie> czesciWMagazynie = new HashSet<>();

    public Magazyn() {
    }

    public int sprawdzStanCzesci(String kodCzesci){
        int ilosc = 0;
        for(var cz : czesciWMagazynie){
            if (cz.getCzescZamienna().getKodCzesci().equals(kodCzesci)){
                ilosc += cz.getStan();
            }
        }
        return ilosc;
    }

    public void usunZMagazynu(CzescWMagazynie czescWMagazynie){
        if (this.czesciWMagazynie.contains(czescWMagazynie)){
            this.czesciWMagazynie.remove(czescWMagazynie);
        }else throw new IllegalArgumentException("Ta częśc nie znajduje się w tym magazynie");
    }


    public Long getId() {
        return id;
    }

    public String getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(String lokalizacja) {
        this.lokalizacja = lokalizacja;
    }
}
