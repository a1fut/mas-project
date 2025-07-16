package org.example.masimplementacja.models.zamowienia;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class CzescWMagazynie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 0)
    private int stan;

    //asocjacje
    @ManyToOne
    @JoinColumn(name = "CZESCZAMIENNA_ID")
    private CzescZamienna czescZamienna;

    @ManyToOne
    @JoinColumn(name = "MAGAZYN_ID")
    private Magazyn magazyn;




    public CzescWMagazynie() {
    }

    public CzescWMagazynie(int stan, CzescZamienna czescZamienna, Magazyn magazyn) {
        this.stan = stan;
        this.czescZamienna = czescZamienna;
        this.magazyn = magazyn;
    }

    public void zmniejszStanO(int ilosc){
        if (ilosc >= this.stan){
            throw new IllegalArgumentException("Nie można zmienić stanu o podaną ilość");
        }
        this.stan -= ilosc;

    }

    public CzescZamienna getCzescZamienna() {
        return czescZamienna;
    }

    public void setCzescZamienna(CzescZamienna czescZamienna) {
        this.czescZamienna = czescZamienna;
    }

    public Magazyn getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(Magazyn magazyn) {
        this.magazyn = magazyn;
    }



    public Long getId() {
        return id;
    }

    public int getStan() {
        return stan;
    }

    public void setStan(int stan) {
        this.stan = stan;
    }

}
