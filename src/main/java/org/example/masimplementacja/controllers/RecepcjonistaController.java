package org.example.masimplementacja.controllers;


import org.example.masimplementacja.models.uzytkownicy.Recepcjonista;
import org.example.masimplementacja.services.RecepcjonistaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping("/recepcjonisci")
public class RecepcjonistaController {

    private final RecepcjonistaService service;


    public RecepcjonistaController(RecepcjonistaService service) {
        this.service = service;
    }

    @GetMapping
    public String listaRecepcjonisci(Model model) {
        model.addAttribute("recepcjonisci", service.findAll());
        return "listaRecepcjonistow";
    }

    @GetMapping("/{id}/zlecenia")
    public String listaZlecenDlaRecepcjonisty(@PathVariable Long id, Model model) {
        Recepcjonista recepcjonista;
        recepcjonista = service.findById(id).orElseThrow();
        model.addAttribute("zlecenia", service.findZlecenia(id));
        model.addAttribute("zalogowany", recepcjonista);
        model.addAttribute("tworcaZgloszen", recepcjonista);
        model.addAttribute("recepcjonisci", service.findAll().stream().filter(r -> !Objects.equals(r.getId(), id)));
        return "listaZlecen";
    }

    @GetMapping("/{zalogowanyId}/zlecenia/podejrzyj/{podgladId}")
    public String podgladZlecen(@PathVariable("zalogowanyId") Long zalogowanyId, @PathVariable("podgladId") Long podgladId, Model model) {
        Recepcjonista zalogowany = service.findById(zalogowanyId).orElseThrow();
        Recepcjonista podgladany = service.findById(podgladId).orElseThrow();


        model.addAttribute("zlecenia", service.findZlecenia(podgladId));
        model.addAttribute("zalogowany", zalogowany);
        model.addAttribute("tworcaZgloszen", podgladany);
        model.addAttribute("recepcjonisci", service.findAll().stream()
                .filter(r -> !Objects.equals(r.getId(), zalogowanyId) && !Objects.equals(r.getId(), podgladId)));

        return "listaZlecen";
    }

}
