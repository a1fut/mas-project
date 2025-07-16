package org.example.masimplementacja.models.zlecenie;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import org.example.masimplementacja.models.zamowienia.CzescZamienna;

@Entity
public class CzesciPotrzebneDoZlecenia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Positive
    private int ilosc;

    @ManyToOne
    @JoinColumn(name = "CZESCZAMIENNA_ID")
    private CzescZamienna czescZamienna;

    @ManyToOne
    @JoinColumn(name = "ZLECENIESERWISOWE_ID")
    private ZlecenieSerwisowe zlecenieSerwisowe;

    public CzesciPotrzebneDoZlecenia() {
    }

    public double getLacznaCenaSprzedazy(){
        return this.ilosc * this.czescZamienna.getCenaSprzedazy();
    }

    private void aktualizujStanMagazynu(){
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
