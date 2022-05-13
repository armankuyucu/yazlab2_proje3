package com.example.yazlab2_proje3;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface ArastirmaciRepository extends Neo4jRepository<ArastirmaciEntity, Long> {
    //    Mono<ArastirmaciEntity> findOneByArastirmaciID(Long arastirmaciID);
    ArastirmaciEntity getByArastirmaciAdi(String arastirmaciAdi);

    Iterable<ArastirmaciEntity> findArastirmaciByArastirmaciAdiLike(String arastirmaciAdi);

    @Query("MATCH(a:Arastirmaci {arastirmaciAdi:$arastirmaci}),(b:Yayin {yayinAdi:$yayin}) MERGE (a)-[r:YAYIN_YAZARI]->(b)")
    ArastirmaciEntity createArastirmaciYayinRelationship(String arastirmaci, String yayin);

    @Query("MATCH(a:Arastirmaci {arastirmaciAdi:$arastirmaci1}),(b:Arastirmaci {arastirmaciAdi:$arastirmaci2}) MERGE (a)-[r:ORTAK_CALISIR]->(b)")
    ArastirmaciEntity createArastirmaciColleagueRelationship(String arastirmaci1,String arastirmaci2);
}
