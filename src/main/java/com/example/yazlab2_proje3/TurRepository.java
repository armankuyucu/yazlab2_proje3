package com.example.yazlab2_proje3;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface TurRepository extends Neo4jRepository<TurEntity, Long> {

    Iterable<TurEntity> findTurByYayinTuruLike(String yayinTuru);

    Iterable<TurEntity> findTurByYayinYeri(String yayinyeri);

}
