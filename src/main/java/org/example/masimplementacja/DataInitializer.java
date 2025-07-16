package org.example.masimplementacja;


import org.example.masimplementacja.enums.RodzajPaliwa;
import org.example.masimplementacja.enums.StatusZlecenie;
import org.example.masimplementacja.models.uzytkownicy.Klient;
import org.example.masimplementacja.models.uzytkownicy.Mechanik;
import org.example.masimplementacja.models.uzytkownicy.Recepcjonista;
import org.example.masimplementacja.models.zlecenie.Pojazd;
import org.example.masimplementacja.models.zlecenie.ZlecenieSerwisowe;
import org.example.masimplementacja.repositories.*;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;



@Component
// klasa do inicjalizowania danych do bazy
public class DataInitializer {
    private final KlientRepository klientRepository;
    private final ZlecenieSerwisoweRepository zlecenieSerwisoweRepository;
    private final PojazdRepository pojazdRepository;
    private final MechanikRepository mechanikRepository;
    private final RecepcjonistaRepository recepcjonistaRepository;
    private Mechanik m1;
    private Klient k1;
    private Recepcjonista r1;
    private Recepcjonista r2;

    private ZlecenieSerwisowe z1;
    private Pojazd p1;

    public DataInitializer(KlientRepository klientRepository, ZlecenieSerwisoweRepository zlecenieSerwisoweRepository, PojazdRepository pojazdRepository, MechanikRepository mechanikRepository, RecepcjonistaRepository recepcjonistaRepository) {
        this.klientRepository = klientRepository;
        this.zlecenieSerwisoweRepository = zlecenieSerwisoweRepository;
        this.pojazdRepository = pojazdRepository;
        this.mechanikRepository = mechanikRepository;
        this.recepcjonistaRepository = recepcjonistaRepository;
    }

    @EventListener
    public void atStart(ContextRefreshedEvent event) {
        m1 = new Mechanik("Jan", "Knap", "600700800", 2, "Silniki Diesla");
        mechanikRepository.save(m1);
        k1 = new Klient("Maciej", "Alfut","506703678");
        klientRepository.save(k1);
        r1 = new Recepcjonista("Anna", "Nowak", "512345889");
        recepcjonistaRepository.save(r1);
        p1 = new Pojazd("BMW", "Seria 1", RodzajPaliwa.DIESEL, "WSE5SX3", k1);
        pojazdRepository.save(p1);
        z1 = new ZlecenieSerwisowe(LocalDateTime.now(), null, StatusZlecenie.NOWE, "Wymiana hamulców", 5, false, m1, r1, p1);
        zlecenieSerwisoweRepository.save(z1);

        r2 = new Recepcjonista("Marcin", "Kuźniewski", "505798445");
        recepcjonistaRepository.save(r2);

        m1 = new Mechanik("Włodzimierz", "Śruba", "506889345", 5, "Tuning");
        mechanikRepository.save(m1);
      }

}
