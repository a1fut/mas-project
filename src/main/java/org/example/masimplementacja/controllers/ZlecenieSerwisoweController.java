package org.example.masimplementacja.controllers;


import jakarta.validation.Valid;
import org.example.masimplementacja.DTOs.WrapperDTO;
import org.example.masimplementacja.repositories.KlientRepository;
import org.example.masimplementacja.repositories.MechanikRepository;
import org.example.masimplementacja.repositories.PojazdRepository;
import org.example.masimplementacja.services.ZlecenieSerwsoweService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recepcjonisci/{recepcjonistaId}/zlecenia/nowezlecenie")
public class ZlecenieSerwisoweController {
    private final ZlecenieSerwsoweService zlecenieSerwsoweService;
    private final MechanikRepository mechanikRepository;
    private final KlientRepository klientRepository;
    private final PojazdRepository pojazdRepository;

    public ZlecenieSerwisoweController(ZlecenieSerwsoweService zlecenieSerwsoweService, MechanikRepository mechanikRepository, KlientRepository klientRepository, PojazdRepository pojazdRepository) {
        this.zlecenieSerwsoweService = zlecenieSerwsoweService;
        this.mechanikRepository = mechanikRepository;
        this.klientRepository = klientRepository;
        this.pojazdRepository = pojazdRepository;
    }

    @ModelAttribute("form")
    public WrapperDTO zlecenieForm(){
        return new WrapperDTO();
    }

    @GetMapping
    public String pokazFormularz(@PathVariable("recepcjonistaId") Long recepcjonistaId, Model model){
        model.addAttribute("recepcjonistaId", recepcjonistaId);
        model.addAttribute("mechanicy", mechanikRepository.findAll());
        model.addAttribute("klienci", klientRepository.findAll());
        model.addAttribute("pojazdy", pojazdRepository.findAll());
        return "noweZlecenieForm";
    }


    @PostMapping
    public String zapiszZlecenie(@PathVariable long recepcjonistaId, @ModelAttribute("form") @Valid WrapperDTO form, BindingResult br, Model model){
        if (br.hasErrors()){
            model.addAttribute("mechanicy", mechanikRepository.findAll());
            model.addAttribute("klienci", klientRepository.findAll());
            model.addAttribute("pojazdy", pojazdRepository.findAll());
            return "noweZlecenieForm";
        }

        zlecenieSerwsoweService.createZlecenieSerwisowe(recepcjonistaId, form.getPojazdDto(), form.getKlientDto(), form.getZlecenieDto());
        return "redirect:/recepcjonisci/" + recepcjonistaId + "/zlecenia";
    }
}
