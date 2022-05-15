package com.example.yazlab2_proje3;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface YayinRepository extends Neo4jRepository<YayinEntity, Long> {
    @Query("MATCH(a:Yayin {yayinAdi:$yayin}),(b:Tur {yayinYeri:$tur}) MERGE (a)-[r:YAYINLANIR]->(b)")
    YayinEntity createYayinTurRelationship(String yayin, String tur);

    Iterable<YayinEntity> findYayinByYayinAdiLike(String yayinAdi);

    Iterable<YayinEntity> findYayinByYayinYili(Long yayinYili);

    @Query("match (a:Arastirmaci)-[r:YAYIN_YAZARI]->(y:Yayin) where a.arastirmaciAdi CONTAINS $arastirmaciAdi return y")
    List<YayinEntity> getYayinEntitiesByArastirmaciAdi(String arastirmaciAdi);

    @Query("match (a:Arastirmaci)-[r:YAYIN_YAZARI]->(y:Yayin) where a.arastirmaciSoyadi CONTAINS $arastirmaciSoyadi return y")
    List<YayinEntity> getYayinEntitiesByArastirmaciSoyadi(String arastirmaciSoyadi);

    @Query("match (y:Yayin)-[r:YAYINLANIR]->(t:Tur) where t.yayinTuru CONTAINS $yayinTuru return y")
    List<YayinEntity> getYayinEntitiesByYayinTuru(String yayinTuru);


}
