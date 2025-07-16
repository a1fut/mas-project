package org.example.masimplementacja.models.uzytkownicy;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.masimplementacja.models.zlecenie.ZlecenieSerwisowe;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Mechanik extends Uzytkownik {


    @Min(1)
    private int stazPracy;
    @NotNull
    @NotBlank(message = "Specjalizacja nie może być pusta")
    @Size(max = 50)
    private String specjalizacja;

    @OneToMany(mappedBy = "mechanik")
    private Set<ZlecenieSerwisowe> zleceniaSerwisowe = new HashSet<>();

    public Mechanik() {
    }

    public Mechanik(String imie, String nazwisko, String nrTelefonu, int stazPracy, String specjalizacja, Set<ZlecenieSerwisowe> zleceniaSerwisowe) {
        super(imie, nazwisko, nrTelefonu);
        this.stazPracy = stazPracy;
        this.specjalizacja = specjalizacja;
        this.zleceniaSerwisowe = zleceniaSerwisowe;
    }
    public Mechanik(String imie, String nazwisko, String nrTelefonu, int stazPracy, String specjalizacja) {
        super(imie, nazwisko, nrTelefonu);
        this.stazPracy = stazPracy;
        this.specjalizacja = specjalizacja;
    }

    public int getStazPracy() {
        return stazPracy;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public void setStazPracy(int stazPracy) {
        this.stazPracy = stazPracy;
    }

    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }
}
