package org.example.masimplementacja.models.zamowienia;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.example.masimplementacja.enums.StatusZamowienia;
import org.example.masimplementacja.enums.StatusZlecenie;
import org.example.masimplementacja.models.uzytkownicy.Dostawca;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Zamowienie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 0)
    private int numerZamowienia;

    @NotNull
    private LocalDateTime dataZlozenia;

    private LocalDateTime dataRealizacji;

    @NotNull
    private StatusZamowienia status;

    //asocjacje
    @ManyToOne
    @JoinColumn(name = "DOSTAWCA_ID")
    private Dostawca dostawca;

    @OneToMany(mappedBy = "zamowienie")
    private Set<PozycjaZamowienie> pozycjeZamowienie;

    public Zamowienie() {
    }

    public void wyslijZamowienie(){
        if (this.status == StatusZamowienia.ZLOZONE){
            this.status = StatusZamowienia.WDRODZE;
        }
    }

    public void przyjmijZamowienie(){
        if (this.status == StatusZamowienia.WDRODZE){
            this.status = StatusZamowienia.ZREALIZOWANE;
        }
    }

    public Long getId() {
        return id;
    }

    public int getNumerZamowienia() {
        return numerZamowienia;
    }

    public void setNumerZamowienia(int numerZamowienia) {
        this.numerZamowienia = numerZamowienia;
    }

    public LocalDateTime getDataZlozenia() {
        return dataZlozenia;
    }

    public void setDataZlozenia(LocalDateTime dataZlozenia) {
        this.dataZlozenia = dataZlozenia;
    }

    public LocalDateTime getDataRealizacji() {
        return dataRealizacji;
    }

    public void setDataRealizacji(LocalDateTime dataRealizacji) {
        this.dataRealizacji = dataRealizacji;
    }

    public StatusZamowienia getStatus() {
        return this.status;
    }

    public void setStatus(StatusZamowienia status) {
        this.status = status;
    }
}
