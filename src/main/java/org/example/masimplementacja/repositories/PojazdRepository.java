package org.example.masimplementacja.repositories;

import org.example.masimplementacja.models.zlecenie.Pojazd;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PojazdRepository extends CrudRepository<Pojazd, Long> {
    Pojazd findByNumerRejestracyjny(String numerRejestracyjny);
}
