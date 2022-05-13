package com.example.yazlab2_proje3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    private final ArastirmaciRepository arastirmaciRepository;
    private final YayinRepository yayinRepository;
    private final TurRepository turRepository;

    public MainController(ArastirmaciRepository arastirmaciRepository, YayinRepository yayinRepository, TurRepository turRepository) {
        this.arastirmaciRepository = arastirmaciRepository;
        this.yayinRepository = yayinRepository;
        this.turRepository = turRepository;
    }

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/adminPanel")
    public String adminPanel(Model model) {
        List<ArastirmaciEntity> arastirmacilar = arastirmaciRepository.findAll();
        List<YayinEntity> yayinlar = yayinRepository.findAll();
        List<TurEntity> turler = turRepository.findAll();

        model.addAttribute("arastirmacilar", arastirmacilar);
        model.addAttribute("yayinlar", yayinlar);
        model.addAttribute("turler", turler);

        model.addAttribute("arastirmaci", new ArastirmaciEntity());
        model.addAttribute("yayin", new YayinEntity());
        model.addAttribute("tur", new TurEntity());

        return "adminPanel";
    }

    @PostMapping("/adminPanel")
    public String createArastirmaci(ArastirmaciEntity newArastirmaci) {
        if (newArastirmaci != null)
            arastirmaciRepository.save(newArastirmaci);
        return "redirect:/adminPanel";
    }

    @PostMapping(value = "/adminPanel/arastirmaciYayinRelationship")
    public String createArastirmaciYayinRelationship(@ModelAttribute ArastirmaciEntity newArastirmaci, @ModelAttribute YayinEntity newYayin) {
        if (newArastirmaci != null && newYayin != null)
            arastirmaciRepository.createArastirmaciYayinRelationship(newArastirmaci.arastirmaciAdi, newYayin.yayinAdi);
        System.out.println("arastirmaci: " + newArastirmaci.arastirmaciAdi + " yayin: " + newYayin.yayinAdi);
        return "redirect:/adminPanel";
    }

    @PostMapping(value = "/adminPanel/arastirmaciColleague")
    public String createArastirmaciColleagueRelationship(ArastirmaciEntity arastirmaci) {
        String[] arastirmaciList;
        if (arastirmaci != null) {
            arastirmaciList = arastirmaci.arastirmaciAdi.split(",");
            System.out.printf("index 0: " + arastirmaciList[0] + " index 1: " + arastirmaciList[1]);
            arastirmaciRepository.createArastirmaciColleagueRelationship(arastirmaciList[0], arastirmaciList[1]);
        } else {
            System.out.println("NULL!!!");
        }

        System.out.println("arastirmaci1: " + arastirmaci.arastirmaciAdi);
        return "redirect:/adminPanel";
    }

    @PostMapping(value = "adminPanel/yayinTurRelationship")
    public String createYayinTurRelationship(YayinEntity yayin, TurEntity tur){
        if(yayin != null && tur != null){
            yayinRepository.createYayinTurRelationship(yayin.yayinAdi, tur.yayinYeri);
        }
        return "redirect:/adminPanel";
    }

    @PostMapping(value = "/adminPanel/yayin")
    public String createYayin(YayinEntity newYayin) {
        yayinRepository.save(newYayin);
        return "redirect:/adminPanel";
    }

    @PostMapping("adminPanel/tur")
    public String createTur(TurEntity newTur) {
        turRepository.save(newTur);
        return "redirect:/adminPanel";
    }
}
