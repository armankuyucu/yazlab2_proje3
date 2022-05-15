package com.example.yazlab2_proje3;

import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.core.transaction.Neo4jTransactionManager;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/")
public class ArastirmaciController {
    private final ArastirmaciRepository arastirmaciRepository;

    public ArastirmaciController(ArastirmaciRepository arastirmaciRepository) {
        this.arastirmaciRepository = arastirmaciRepository;
    }

    @PostMapping("/post")
    public ArastirmaciEntity createArastirmaci(@RequestBody ArastirmaciEntity newArastirmaci) {
        return arastirmaciRepository.save(newArastirmaci);
    }

    @GetMapping("/find")
    public Iterable<ArastirmaciEntity> findAll() {
//        Iterable<ArastirmaciEntity> findAll= arastirmaciRepository.findAll();
//        model.put("arastimacilar", findAll);
////        model.put("arastimaci", new ArastirmaciEntity());
//        return "index";
        return arastirmaciRepository.findAll();
    }

    @GetMapping("/{arastirmaciAdi}")
    public ArastirmaciEntity getByArastirmaciAdi(@PathVariable String arastirmaciAdi) {
        return arastirmaciRepository.getByArastirmaciAdi(arastirmaciAdi);
    }

    @GetMapping("/search/{arastirmaciAdi}")
    public Iterable<ArastirmaciEntity> findArastirmaciByArastirmaciAdiLike(@PathVariable String arastirmaciAdi) {
        return arastirmaciRepository.findArastirmaciByArastirmaciAdiLike(arastirmaciAdi);
    }


//    @GetMapping("/by-id")
//    Mono<ArastirmaciEntity> byID(@RequestParam Long arastirmaciID) {
//        return arastirmaciRepository.findOneByArastirmaciID(arastirmaciID);
//    }

}
