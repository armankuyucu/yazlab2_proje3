package com.example.yazlab2_proje3;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface ArastirmaciRepository extends Neo4jRepository<ArastirmaciEntity, Long> {
    //    Mono<ArastirmaciEntity> findOneByArastirmaciID(Long arastirmaciID);
    ArastirmaciEntity getByArastirmaciAdi(String arastirmaciAdi);

    Iterable<ArastirmaciEntity> findArastirmaciByArastirmaciAdiLike(String arastirmaciAdi);

    @Query("MATCH(a:Arastirmaci {arastirmaciAdi:$arastirmaci}),(b:Yayin {yayinAdi:$yayin}) MERGE (a)-[r:YAYIN_YAZARI]->(b)")
    ArastirmaciEntity createArastirmaciYayinRelationship(String arastirmaci, String yayin);
}
