package com.example.yazlab2_proje3;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Node("Arastirmaci")
public class ArastirmaciEntity {
    @Id
    public final Long arastirmaciID;

    public final String arastirmaciAdi;
    public final String arastirmaciSoyadi;

    @Relationship(type = "Yayin Yazari")
    public List<YayinEntity> yayinlar;

    @Relationship(type = "Ortak Calisir")
    public List<ArastirmaciEntity> ortakArastirmacilar;


    public ArastirmaciEntity(Long arastirmaciID, String arastirmaciAdi, String arastirmaciSoyadi, List<YayinEntity> yayinlar, List<ArastirmaciEntity> ortakArastirmacilar) {
        this.arastirmaciID = arastirmaciID;
        this.arastirmaciAdi = arastirmaciAdi;
        this.arastirmaciSoyadi = arastirmaciSoyadi;
        this.yayinlar = yayinlar;
        this.ortakArastirmacilar = ortakArastirmacilar;
    }

    public Long getArastirmaciID() {
        return arastirmaciID;
    }

    public String getArastirmaciAdi() {
        return arastirmaciAdi;
    }

    public String getArastirmaciSoyadi() {
        return arastirmaciSoyadi;
    }

    public List<YayinEntity> getYayinlar() {
        return yayinlar;
    }

    public List<ArastirmaciEntity> getOrtakArastirmacilar() {
        return ortakArastirmacilar;
    }

}
