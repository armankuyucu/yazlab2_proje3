package com.example.yazlab2_proje3;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Node("Arastirmaci")
public class ArastirmaciEntity {
    @Id
    @GeneratedValue
    public Long arastirmaciID;

    public String arastirmaciAdi;
    public String arastirmaciSoyadi;

    @Relationship(type = "YAYIN_YAZARI")
    public List<YayinEntity> yayinlar;

//    public void yayinlar(YayinEntity yayin){
//        if(yayinlar == null) {
//            yayinlar = new ArrayList<>();
//        }
//        yayinlar.add(yayin);
//    }
    @Relationship(type = "Ortak Calisir")
    public List<ArastirmaciEntity> ortakArastirmacilar;


    public ArastirmaciEntity(Long arastirmaciID, String arastirmaciAdi, String arastirmaciSoyadi, List<YayinEntity> yayinlar, List<ArastirmaciEntity> ortakArastirmacilar) {
        this.arastirmaciID = arastirmaciID;
        this.arastirmaciAdi = arastirmaciAdi;
        this.arastirmaciSoyadi = arastirmaciSoyadi;
        this.yayinlar = yayinlar;
        this.ortakArastirmacilar = ortakArastirmacilar;
    }

    public ArastirmaciEntity() {

    }

    @Override
    public String toString() {
        return "ArastirmaciEntity{" +
                "arastirmaciAdi='" + arastirmaciAdi + '\'' +
                ", arastirmaciSoyadi='" + arastirmaciSoyadi + '\'' +
                '}';
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

    public void setArastirmaciID(Long arastirmaciID) {
        this.arastirmaciID = arastirmaciID;
    }

    public void setArastirmaciAdi(String arastirmaciAdi) {
        this.arastirmaciAdi = arastirmaciAdi;
    }

    public void setArastirmaciSoyadi(String arastirmaciSoyadi) {
        this.arastirmaciSoyadi = arastirmaciSoyadi;
    }

    public void setYayinlar(List<YayinEntity> yayinlar) {
        this.yayinlar = yayinlar;
    }

    public void setOrtakArastirmacilar(List<ArastirmaciEntity> ortakArastirmacilar) {
        this.ortakArastirmacilar = ortakArastirmacilar;
    }

}
