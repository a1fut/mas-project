package org.example.masimplementacja.models.zamowienia;


import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

@Entity
public class PozycjaZamowienie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Positive
    private int ilosc;

    // asocjacje

    @ManyToOne
    @JoinColumn(name = "CZESCZAMIENNA_ID")
    private CzescZamienna czescZamienna;

    @ManyToOne
    @JoinColumn(name = "ZAMOWIENIE_ID")
    private Zamowienie zamowienie;


    public PozycjaZamowienie() {
    }

    public double getCenaZakupu(){
        return this.ilosc * czescZamienna.getCenaKupna();
    }

    public Long getId() {
        return id;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}
