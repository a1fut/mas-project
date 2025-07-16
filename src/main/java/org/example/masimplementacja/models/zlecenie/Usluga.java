package org.example.masimplementacja.models.zlecenie;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Usluga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank(message = "Nazwa nie może być pusta")
    @Size(max = 150)
    private String nazwa;

    @Positive
    private double stawkaGodzinowa;


    //asocjacje
    @OneToMany(mappedBy = "usluga")
    private Set<UslugaZlecenie> uslugiZlecenia = new HashSet<>();

    public Usluga() {
    }


    public Long getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getStawkaGodzinowa() {
        return stawkaGodzinowa;
    }

    public void setStawkaGodzinowa(double stawkaGodzinowa) {
        this.stawkaGodzinowa = stawkaGodzinowa;
    }
}
