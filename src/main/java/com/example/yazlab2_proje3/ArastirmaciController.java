package com.example.yazlab2_proje3;

import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.core.transaction.Neo4jTransactionManager;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class ArastirmaciController {
    private final ArastirmaciRepository arastirmaciRepository;

    public ArastirmaciController(ArastirmaciRepository arastirmaciRepository) {
        this.arastirmaciRepository = arastirmaciRepository;
    }

    @PutMapping
    ArastirmaciEntity createOrUpdateMovie(@RequestBody ArastirmaciEntity newMovie) {
        return arastirmaciRepository.save(newMovie);
    }

    @GetMapping
    Iterable<ArastirmaciEntity> findAll() {
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
