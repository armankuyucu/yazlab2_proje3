package com.example.yazlab2_proje3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Iterator;
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


    @GetMapping(value = {"/userPanel",""})
    public String userPanel(Model model){
        List<ArastirmaciEntity> arastirmacilar = arastirmaciRepository.findAll();
        List<YayinEntity> yayinlar = yayinRepository.findAll();
        List<TurEntity> turler = turRepository.findAll();
        model.addAttribute("arastirmacilar", arastirmacilar);
        model.addAttribute("yayinlar", yayinlar);
        model.addAttribute("turler", turler);
        model.addAttribute("arastirmaci",new ArastirmaciEntity());
        model.addAttribute("yayin",new YayinEntity());
        model.addAttribute("tur",new TurEntity());

        return "userPanel";
    }

    @GetMapping("/userPanel/{arastirmaciAdi}")
    public Iterable<ArastirmaciEntity> findArastirmaciByArastirmaciAdiLike(@PathVariable String arastirmaciAdi) {
        return arastirmaciRepository.findArastirmaciByArastirmaciAdiLike(arastirmaciAdi);
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
        model.addAttribute("newArastirmaci", new ArastirmaciEntity());

        model.addAttribute("yayin", new YayinEntity());
        model.addAttribute("tur", new TurEntity());

        return "adminPanel";
    }

    @PostMapping("/results")
    public String searchByArastirmaci(Model model, YayinEntity yayin,ArastirmaciEntity arastirmaci) {
            model.addAttribute("arastirmaciInfo",arastirmaci);
            if(arastirmaci.getArastirmaciAdi() != null){
                model.addAttribute("arastirmacilar",arastirmaciRepository.findArastirmaciByArastirmaciAdiLike(arastirmaci.getArastirmaciAdi()));
                model.addAttribute("arastirmaciYayinlari",yayinRepository.getYayinEntitiesByArastirmaciAdi(arastirmaci.getArastirmaciAdi()));
                for (YayinEntity arastirmaciYayin: yayinRepository.getYayinEntitiesByArastirmaciAdi(arastirmaci.getArastirmaciAdi())) {
                    System.out.println("arastirmaci yayin: " + arastirmaciYayin.getYayinAdi());
                }
                return "arastirmaci-sonuc";

            } else if((arastirmaci.getArastirmaciSoyadi() != null)){
                model.addAttribute("arastirmacilar",arastirmaciRepository.findArastirmaciByArastirmaciSoyadiLike(arastirmaci.getArastirmaciSoyadi()));
                model.addAttribute("arastirmaciYayinlari",yayinRepository.getYayinEntitiesByArastirmaciSoyadi(arastirmaci.getArastirmaciSoyadi()));
                return "arastirmaci-sonuc";
            }
            else if(yayin.getYayinAdi() != null){
                model.addAttribute("yayinlar",yayinRepository.findYayinByYayinAdiLike(yayin.getYayinAdi()));
                model.addAttribute("yayinYazari",removeDuplicateArastirmaciEntities(arastirmaciRepository.getArastirmaciEntitiesByYayinAdi(yayin.getYayinAdi())));
//                model.addAttribute("yayinYazari",arastirmaciRepository.getArastirmaciEntitiesByYayinAdi(yayin.getYayinAdi()));
                return "yayin-sonuc";
            } else if((yayin.getYayinYili() != null)){
                model.addAttribute("yayinlar",yayinRepository.findYayinByYayinYili(yayin.getYayinYili()));
                model.addAttribute("yayinYazari",removeDuplicateArastirmaciEntities(arastirmaciRepository.getArastirmaciEntitiesByYayinYili(yayin.getYayinYili())));
//                model.addAttribute("yayinYazari",arastirmaciRepository.getArastirmaciEntitiesByYayinYili(yayin.getYayinYili()));
                return "yayin-sonuc";
            }


        return "redirect:/userPanel";
    }

    public List<ArastirmaciEntity> removeDuplicateArastirmaciEntities(List<ArastirmaciEntity> arastirmaciEntities){
        for (int i=0;i<arastirmaciEntities.size()-1;i++) {
            for(int j=0;j<arastirmaciEntities.size()-1;j++)
            if(arastirmaciEntities.get(i).getArastirmaciAdi().equals(arastirmaciEntities.get(j).getArastirmaciAdi())){
                System.out.println("SİLİNEN: " + arastirmaciEntities.get(j));
                arastirmaciEntities.remove(arastirmaciEntities.get(j));
            }
        }
        return arastirmaciEntities;
    }
    @PostMapping("/arastirmaci-sonuc")
    public String arastirmaciSonuc(){
        return "arastirmaci-sonuc";
    }

    @PostMapping("/yayin-sonuc")
    public String yayinSonuc(){
        return "yayin-sonuc";
    }

    @PostMapping("/adminPanel/arastirmaci")
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

//    @Query("match (a:Arastirmaci {arastirmaciAdi:$arastirmaciAdi})-[r:YAYIN_YAZARI]->(y:Yayin) return $y")
//    Iterable<YayinEntity> findByYayinRelationship(@PathVariable String arastirmaciAdi,@PathVariable Iterable<YayinEntity> y){
//        return y;
//    }
}
