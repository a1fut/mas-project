package org.example.masimplementacja.models.zlecenie;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.example.masimplementacja.enums.StatusZlecenie;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class UslugaZlecenie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Positive
    private double czasWykonywania;

    @ManyToOne
    @JoinColumn(name = "zlecenieserwisowe_id")
    private ZlecenieSerwisowe zlecenieSerwisowe;

    @ManyToOne
    @JoinColumn(name = "usluga_id")
    private Usluga usluga;

    public UslugaZlecenie() {
    }

    public double getKwota(){
        return czasWykonywania * usluga.getStawkaGodzinowa();
    }

    public Long getId() {
        return id;
    }

    public double getCzasWykonywania() {
        return czasWykonywania;
    }

    public void setCzasWykonywania(double czasWykonywania) {
        this.czasWykonywania = czasWykonywania;
    }
}
