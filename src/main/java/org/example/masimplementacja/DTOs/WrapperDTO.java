package org.example.masimplementacja.DTOs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class WrapperDTO {

    @NotNull
    @Valid
    private KlientAddDTO klientDto;
    @NotNull
    @Valid
    private PojazdAddDTO pojazdDto;
    @NotNull
    @Valid
    private ZlecenieSerwisoweAddDTO zlecenieDto;


    public KlientAddDTO getKlientDto() {
        return klientDto;
    }

    public void setKlientDto(KlientAddDTO klientDto) {
        this.klientDto = klientDto;
    }

    public PojazdAddDTO getPojazdDto() {
        return pojazdDto;
    }

    public void setPojazdDto(PojazdAddDTO pojazdDto) {
        this.pojazdDto = pojazdDto;
    }

    public ZlecenieSerwisoweAddDTO getZlecenieDto() {
        return zlecenieDto;
    }

    public void setZlecenieDto(ZlecenieSerwisoweAddDTO zlecenieDto) {
        this.zlecenieDto = zlecenieDto;
    }
}
