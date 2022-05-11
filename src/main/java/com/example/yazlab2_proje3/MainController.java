package com.example.yazlab2_proje3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class MainController {
    private final ArastirmaciRepository arastirmaciRepository;

    public MainController(ArastirmaciRepository arastirmaciRepository) {
        this.arastirmaciRepository = arastirmaciRepository;
    }

    @GetMapping("")
    public String Get(Model model){
        List<ArastirmaciEntity> allArastirmaci = arastirmaciRepository.findAll();
        for(ArastirmaciEntity arastirmaci : allArastirmaci)
            System.out.println("ARASTIRMACI: " + arastirmaci.arastirmaciAdi);
        model.addAttribute(
                "arastirmacilar", allArastirmaci);
        model.addAttribute("newArastirmaci", new ArastirmaciEntity());
        return "index";
    }

    @PostMapping("")
    public String createArastirmaci(ArastirmaciEntity newArastirmaci) {
        arastirmaciRepository.save(newArastirmaci);
        return "redirect:/";
    }
}
