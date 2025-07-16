package org.example.masimplementacja.services;

import org.example.masimplementacja.models.uzytkownicy.Recepcjonista;
import org.example.masimplementacja.models.zlecenie.ZlecenieSerwisowe;
import org.example.masimplementacja.repositories.RecepcjonistaRepository;
import org.example.masimplementacja.repositories.ZlecenieSerwisoweRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecepcjonistaService {
    private final RecepcjonistaRepository recepcjonistaRepo;
    private final ZlecenieSerwisoweRepository zlecenieRepo;

    public RecepcjonistaService(RecepcjonistaRepository repo, ZlecenieSerwisoweRepository zlecenieRepo) {
        this.recepcjonistaRepo = repo;
        this.zlecenieRepo = zlecenieRepo;
    }

    public Optional<Recepcjonista> findById(Long id){
        return recepcjonistaRepo.findById(id);
    }
    public List<Recepcjonista> findAll(){
        return (List<Recepcjonista>) recepcjonistaRepo.findAll();
    }

    public List<ZlecenieSerwisowe> findZlecenia(Long recepcjonistaId){
        return zlecenieRepo.findByRecepcjonistaId(recepcjonistaId);
    }
}
