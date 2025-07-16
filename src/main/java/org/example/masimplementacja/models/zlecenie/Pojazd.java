package org.example.masimplementacja.models.zlecenie;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.masimplementacja.enums.RodzajPaliwa;
import org.example.masimplementacja.models.uzytkownicy.Klient;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Pojazd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank(message = "Marka nie może być pusta")
    @Size(max = 20)
    private String marka;

    @NotNull
    @NotBlank(message = "Model nie może być pusty")
    @Size(max = 30)
    private String model;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RodzajPaliwa rodzajPaliwa;

    @NotNull
    @NotBlank(message = "Numer rejestracyjny nie może być pusty")
    @Size(min = 7, max = 8)
    private String numerRejestracyjny;

    public Pojazd(String marka, String model, RodzajPaliwa rodzajPaliwa, String numerRejestracyjny, Klient klient, Set<ZlecenieSerwisowe> zleceniaSerwisowe) {
        this.marka = marka;
        this.model = model;
        this.rodzajPaliwa = rodzajPaliwa;
        this.numerRejestracyjny = numerRejestracyjny;
        this.klient = klient;
        this.zleceniaSerwisowe = zleceniaSerwisowe;
    }
    public Pojazd(String marka, String model, RodzajPaliwa rodzajPaliwa, String numerRejestracyjny, Klient klient) {
        this.marka = marka;
        this.model = model;
        this.rodzajPaliwa = rodzajPaliwa;
        this.numerRejestracyjny = numerRejestracyjny;
        this.klient = klient;
    }

    //asocjacje

    //kompozycja - część
    @ManyToOne(optional = false)
    @JoinColumn(name = "klient_id", nullable = false, updatable = false)
    private Klient klient;

    //kompozycja - całość
    @OneToMany(mappedBy = "pojazd", cascade = CascadeType.REMOVE)
    private Set<ZlecenieSerwisowe> zleceniaSerwisowe = new HashSet<>();

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Klient getKlient() {
        return klient;
    }

    public Pojazd() {

    }



    public Long getId() {
        return id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public RodzajPaliwa getRodzajPaliwa() {
        return rodzajPaliwa;
    }

    public void setRodzajPaliwa(RodzajPaliwa rodzajPaliwa) {
        this.rodzajPaliwa = rodzajPaliwa;
    }

    public String getNumerRejestracyjny() {
        return numerRejestracyjny;
    }

    public void setNumerRejestracyjny(String numerRejestracyjny) {
        this.numerRejestracyjny = numerRejestracyjny;
    }

    @Override
    public String toString() {
        return this.marka + " " + this.model + " " + this.numerRejestracyjny;
    }
}
