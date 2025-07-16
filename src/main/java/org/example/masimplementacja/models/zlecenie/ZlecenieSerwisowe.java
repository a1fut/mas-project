package org.example.masimplementacja.models.zlecenie;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.example.masimplementacja.enums.StatusZlecenie;
import org.example.masimplementacja.models.uzytkownicy.Mechanik;
import org.example.masimplementacja.models.uzytkownicy.Recepcjonista;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ZlecenieSerwisowe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private LocalDateTime dataStartu;

    // kolumna nullowalna - w innym usecas'ie aktualizowana przez mechanika
    private LocalDateTime dataZakonczenia;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusZlecenie statusZlecenia;

    @NotNull
    @NotBlank(message = "Opis nie może być pusty")
    private String opis;

    @Min(0)
    @Max(15)
    private int wysokoscZnizki;

    private boolean czyOplacone;


    // asocjacje

    @ManyToOne
    @JoinColumn(name = "mechanik_id")
    private Mechanik mechanik;

    @ManyToOne
    @JoinColumn(name = "recepcjonista_id")
    private Recepcjonista recepcjonista;

    //kompozycja - część
    @ManyToOne(optional = false)
    @JoinColumn(name = "pojazd_id", nullable = false, updatable = false)
    private Pojazd pojazd;

    @OneToMany(mappedBy = "zlecenieSerwisowe")
    private Set<UslugaZlecenie> uslugiZlecenia = new HashSet<>();

    @OneToMany(mappedBy = "zlecenieSerwisowe")
    private Set<CzesciPotrzebneDoZlecenia> czesciPotrzebneDoZlecenia = new HashSet<>();


    public ZlecenieSerwisowe() {
    }

    public ZlecenieSerwisowe(LocalDateTime dataStartu, LocalDateTime dataZakonczenia,
                             StatusZlecenie statusZlecenia, String opis, int wysokoscZnizki,
                             boolean czyOplacone, Mechanik mechanik, Recepcjonista recepcjonista, Pojazd pojazd) {

        this.dataStartu = dataStartu;
        this.dataZakonczenia = dataZakonczenia;
        this.statusZlecenia = statusZlecenia;
        this.opis = opis;
        this.wysokoscZnizki = wysokoscZnizki;
        this.czyOplacone = czyOplacone;
        this.mechanik = mechanik;
        this.recepcjonista = recepcjonista;
        this.pojazd = pojazd;
    }

    public Pojazd getPojazd() {
        return pojazd;
    }

    public double getCenaKoncowa() {
        double cenaKoncowa = 0;
        if (!this.uslugiZlecenia.isEmpty())
            for (var uz : this.uslugiZlecenia) {
                cenaKoncowa += uz.getKwota();
            }
        if (!this.czesciPotrzebneDoZlecenia.isEmpty())
            for (var cpdz : czesciPotrzebneDoZlecenia) {
                cenaKoncowa += cpdz.getLacznaCenaSprzedazy();
            }
        cenaKoncowa = cenaKoncowa * (100 - wysokoscZnizki) / 100;
        return cenaKoncowa;
    }


    public void zacznijPraceNadZleceniem(){
        if (this.statusZlecenia == StatusZlecenie.NOWE){
            this.statusZlecenia = StatusZlecenie.WTRAKCIE;
        } else throw new IllegalArgumentException("W tym momencie nie można ustawić statusu zlecenia na \"W trakcie\"");
    }

    public void zakonczPraceNadZleceniem(){
        if (this.statusZlecenia == StatusZlecenie.WTRAKCIE){
            this.statusZlecenia = StatusZlecenie.DOZAPLATY;
        } else throw new IllegalArgumentException("W tym momencie nie można ustawić statusu zlecenia na \"Do zapłaty\"");
    }

    public void oplacZlecenie(){
        if (this.statusZlecenia == StatusZlecenie.DOZAPLATY){
            this.statusZlecenia = StatusZlecenie.WYKONANO;
            this.czyOplacone = true;
        } else throw new IllegalArgumentException("W tym momencie nie można ustawić statusu zlecenia na \"Wykonano\"");
    }



    public Mechanik getMechanik() {
        return mechanik;
    }


    public void setMechanik(Mechanik mechanik) {
        this.mechanik = mechanik;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataStartu() {
        return dataStartu;
    }

    public void setDataStartu(LocalDateTime dataStartu) {
        this.dataStartu = dataStartu;
    }

    public LocalDateTime getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(LocalDateTime dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public StatusZlecenie getStatusZlecenia() {
        return statusZlecenia;
    }

    public void setStatusZlecenia(StatusZlecenie statusZlecenia) {
        this.statusZlecenia = statusZlecenia;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getWysokoscZnizki() {
        return wysokoscZnizki;
    }

    public void setWysokoscZnizki(int wysokoscZnizki) {
        this.wysokoscZnizki = wysokoscZnizki;
    }

    public boolean isCzyOplacone() {
        return czyOplacone;
    }

    public void setCzyOplacone(boolean czyOplacone) {
        this.czyOplacone = czyOplacone;
    }
}
