package org.example.masimplementacja.DTOs;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class ZlecenieSerwisoweAddDTO {
    @NotNull(message = "Data startu nie może być pusta")
    private LocalDateTime dataStartu;

    private LocalDateTime dataZakonczenia;

    @NotBlank(message = "Opis nie może być pusty")
    @Size(max = 250, message = "Opis nie może być dłuższy niż 250 znaków")
    private String opis;

    @Min(value = 0, message = "Minimalna wartość zniżki wynosi 0%")
    @Max(value = 15, message = "Maksymalna wartość zniżki to 15%")
    private int wysokoscZnizki;

    @NotNull
    private boolean czyOplacone;

    @NotNull
    @Positive
    private Long mechanikId;

    public Long getMechanikId() {
        return mechanikId;
    }

    public void setMechanikId(Long mechanikId) {
        this.mechanikId = mechanikId;
    }

    public ZlecenieSerwisoweAddDTO() {    }

    public boolean isCzyOplacone() {
        return czyOplacone;
    }

    public void setCzyOplacone(boolean czyOplacone) {
        this.czyOplacone = czyOplacone;
    }

    public int getWysokoscZnizki() {
        return wysokoscZnizki;
    }

    public void setWysokoscZnizki(int wysokoscZnizki) {
        this.wysokoscZnizki = wysokoscZnizki;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public LocalDateTime getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(LocalDateTime dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public LocalDateTime getDataStartu() {
        return dataStartu;
    }

    public void setDataStartu(LocalDateTime dataStartu) {
        this.dataStartu = dataStartu;
    }
}

