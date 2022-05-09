package com.example.yazlab2_proje3;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import reactor.core.publisher.Mono;

public interface ArastirmaciRepository extends Neo4jRepository<ArastirmaciEntity,Long> {
//    Mono<ArastirmaciEntity> findOneByArastirmaciID(Long arastirmaciID);
    public ArastirmaciEntity getByArastirmaciAdi(String arastirmaciAdi);
    Iterable<ArastirmaciEntity> findArastirmaciByArastirmaciAdiLike(String arastirmaciAdi);

}
