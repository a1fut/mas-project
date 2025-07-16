package org.example.masimplementacja.repositories;

import org.example.masimplementacja.models.uzytkownicy.Klient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlientRepository extends CrudRepository<Klient, Long> {
}
