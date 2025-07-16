package org.example.masimplementacja.repositories;

import org.example.masimplementacja.models.zlecenie.ZlecenieSerwisowe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZlecenieSerwisoweRepository extends CrudRepository<ZlecenieSerwisowe, Long> {
    List<ZlecenieSerwisowe> findByRecepcjonistaId(Long recepcjonistaId);
}
