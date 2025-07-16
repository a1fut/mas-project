package org.example.masimplementacja.repositories;

import org.example.masimplementacja.models.uzytkownicy.Recepcjonista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecepcjonistaRepository extends CrudRepository<Recepcjonista, Long> {
}
