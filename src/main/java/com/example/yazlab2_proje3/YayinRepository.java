package com.example.yazlab2_proje3;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface YayinRepository extends Neo4jRepository<YayinEntity, Long> {
    @Query("MATCH(a:Yayin {yayinAdi:$yayin}),(b:Tur {yayinYeri:$tur}) MERGE (a)-[r:YAYINLANIR]->(b)")
    YayinEntity createYayinTurRelationship(String yayin, String tur);

    Iterable<YayinEntity> findYayinByYayinAdiLike(String yayinAdi);

    Iterable<YayinEntity> findYayinByYayinYili(Long yayinYili);
}
