package org.example.masimplementacja.models.uzytkownicy;

import jakarta.persistence.*;
import org.example.masimplementacja.models.zlecenie.ZlecenieSerwisowe;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Recepcjonista extends Uzytkownik {



    public Recepcjonista() {
    }


    public Recepcjonista(String imie, String nazwisko, String nrTelefonu, Set<ZlecenieSerwisowe> zleceniaSerwisowe) {
        super(imie, nazwisko, nrTelefonu);
        this.zleceniaSerwisowe = zleceniaSerwisowe;
    }

    public Recepcjonista(String imie, String nazwisko, String nrTelefonu) {
        super(imie, nazwisko, nrTelefonu);
    }

    @OneToMany(mappedBy = "recepcjonista")
    private Set<ZlecenieSerwisowe> zleceniaSerwisowe = new HashSet<>();




}
