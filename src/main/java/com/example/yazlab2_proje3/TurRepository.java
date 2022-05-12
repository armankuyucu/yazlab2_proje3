package com.example.yazlab2_proje3;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TurRepository extends Neo4jRepository<TurEntity, Long> {
}
