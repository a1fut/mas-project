package org.example.masimplementacja.repositories;

import org.example.masimplementacja.models.uzytkownicy.Mechanik;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MechanikRepository extends CrudRepository<Mechanik, Long> {
}
