package com.example.yazlab2_proje3;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ArastirmaciRepository extends Neo4jRepository<ArastirmaciEntity, Long> {
    //    Mono<ArastirmaciEntity> findOneByArastirmaciID(Long arastirmaciID);
    ArastirmaciEntity getByArastirmaciAdi(String arastirmaciAdi);

    Iterable<ArastirmaciEntity> findArastirmaciByArastirmaciAdiLike(String arastirmaciAdi);
    Iterable<ArastirmaciEntity> findArastirmaciByArastirmaciSoyadiLike(String arastirmaciSoyadi);

//    @Query("match (a:Arastirmaci {arastirmaciAdi:$arastirmaciAdi})-[r:YAYIN_YAZARI]->(y:Yayin) return $y")
//    List<YayinEntity> findByYayinRelationship(@PathVariable String arastirmaciAdi, @PathVariable YayinEntity $y);
    @Query("MATCH(a:Arastirmaci {arastirmaciAdi:$arastirmaci}),(b:Yayin {yayinAdi:$yayin}) MERGE (a)-[r:YAYIN_YAZARI]->(b)")
    ArastirmaciEntity createArastirmaciYayinRelationship(String arastirmaci, String yayin);

    @Query("MATCH (a:Arastirmaci)-[r:YAYIN_YAZARI]->(y:Yayin {yayinAdi:$yayinAdi}) return a")
    List<ArastirmaciEntity> getArastirmaciEntitiesByYayinAdi(String yayinAdi);
    @Query("MATCH (a:Arastirmaci)-[r:YAYIN_YAZARI]->(y:Yayin {yayinYili:$yayinYili}) return a")
    List<ArastirmaciEntity> getArastirmaciEntitiesByYayinYili(Long yayinYili);

    @Query("MATCH(a:Arastirmaci {arastirmaciAdi:$arastirmaci1}),(b:Arastirmaci {arastirmaciAdi:$arastirmaci2}) MERGE (a)-[r:ORTAK_CALISIR]->(b)")
    ArastirmaciEntity createArastirmaciColleagueRelationship(String arastirmaci1,String arastirmaci2);
}
