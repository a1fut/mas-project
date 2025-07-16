package org.example.masimplementacja.models.uzytkownicy;

import jakarta.persistence.*;
import org.example.masimplementacja.models.zlecenie.Pojazd;
import org.example.masimplementacja.models.zlecenie.ZlecenieSerwisowe;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Klient extends Uzytkownik{

    public Klient() {
    }

    public Klient(String imie, String nazwisko, String nrTelefonu) {
        super(imie, nazwisko, nrTelefonu);
    }

    //kompozycja - całosć
    @OneToMany(mappedBy = "klient", cascade = CascadeType.REMOVE)
    private Set<Pojazd> pojazdy = new HashSet<>();

    public Set<Pojazd> getPojazdy() {
        return pojazdy;
    }

    public void setPojazdy(Set<Pojazd> pojazdy) {
        this.pojazdy = pojazdy;
    }
}
