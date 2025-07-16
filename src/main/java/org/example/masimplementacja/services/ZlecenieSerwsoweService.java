package org.example.masimplementacja.services;


import jakarta.transaction.Transactional;
import org.example.masimplementacja.DTOs.KlientAddDTO;
import org.example.masimplementacja.DTOs.PojazdAddDTO;
import org.example.masimplementacja.DTOs.ZlecenieSerwisoweAddDTO;
import org.example.masimplementacja.enums.StatusZlecenie;
import org.example.masimplementacja.models.uzytkownicy.Klient;
import org.example.masimplementacja.models.uzytkownicy.Mechanik;
import org.example.masimplementacja.models.uzytkownicy.Recepcjonista;
import org.example.masimplementacja.models.zlecenie.Pojazd;
import org.example.masimplementacja.models.zlecenie.ZlecenieSerwisowe;
import org.example.masimplementacja.repositories.*;
import org.springframework.stereotype.Service;

@Service
public class ZlecenieSerwsoweService {
    private final KlientRepository klientRepository;
    private final MechanikRepository mechanikRepository;
    private final RecepcjonistaRepository recepcjonistaRepository;
    private final ZlecenieSerwisoweRepository zlecenieSerwisoweRepository;
    private final PojazdRepository pojazdRepository;

    public ZlecenieSerwsoweService(KlientRepository klientRepository, MechanikRepository mechanikRepository, RecepcjonistaRepository recepcjonistaRepository, ZlecenieSerwisoweRepository zlecenieSerwisoweRepository, PojazdRepository pojazdRepository) {
        this.klientRepository = klientRepository;
        this.mechanikRepository = mechanikRepository;
        this.recepcjonistaRepository = recepcjonistaRepository;
        this.zlecenieSerwisoweRepository = zlecenieSerwisoweRepository;
        this.pojazdRepository = pojazdRepository;
    }

    @Transactional
    public void createZlecenieSerwisowe(Long recepcjonistaId, PojazdAddDTO pojazdDto, KlientAddDTO klientDto, ZlecenieSerwisoweAddDTO zlecenieDto) {
        Klient klient;

        Pojazd pojazd;
        //gdy pojazd istnieje, nie ma potrzeby wprowadzania danych nowego klienta

        if (pojazdDto.isCzyIstnieje()){
            pojazd = pojazdRepository.findById(pojazdDto.getId()).orElseThrow(() -> new IllegalArgumentException("Pojazd o tym id nie istnieje"));
        }else {
            // jeżeli pojazd zaś nie istnieje, mamy do wyboru przypisanie go do istniejącego klienta lub stworzenie nowego
            if (klientDto.isCzyIstnieje())
                klient = klientRepository.findById(klientDto.getId()).orElseThrow(() -> new IllegalArgumentException("Klient o tym id nie istnieje"));
            else {
                klient = new Klient(klientDto.getImie(), klientDto.getNazwisko(), klientDto.getNrTelefonu());
                klientRepository.save(klient);
            }

            pojazd = new Pojazd(pojazdDto.getMarka(), pojazdDto.getModel(), pojazdDto.getRodzajPaliwa(), pojazdDto.getNumerRejestracyjny(), klient);
            pojazdRepository.save(pojazd);
        }

        Mechanik mechanik = mechanikRepository.findById(zlecenieDto.getMechanikId()).orElseThrow((() -> new IllegalArgumentException("Mechanik o tym id nie istnieje")));
        Recepcjonista recepcjonista = recepcjonistaRepository.findById(recepcjonistaId).orElseThrow();


        //ustawione "na sztywno" atrybuty nowego zlecenia serwisowego wynikają z dokumentacji

        ZlecenieSerwisowe zlecenieSerwisowe = new ZlecenieSerwisowe(
                zlecenieDto.getDataStartu(),
                null,
                StatusZlecenie.NOWE,
                zlecenieDto.getOpis(),
                zlecenieDto.getWysokoscZnizki(),
                false,
                mechanik,
                recepcjonista,
                pojazd
        );

        zlecenieSerwisoweRepository.save(zlecenieSerwisowe);
    }

}
