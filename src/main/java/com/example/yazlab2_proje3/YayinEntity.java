package com.example.yazlab2_proje3;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node("Yayin")
public class YayinEntity {
    @Id
    @GeneratedValue
    public Long yayinID;
    public String yayinAdi;
    public Long yayinYili;

//    @Relationship(type = "Yayin Turu")
//    public List<TurEntity> yayinTuru;
//
//    @Relationship(type = "Yayin Yeri")
//    public List<TurEntity> yayinYeri;

    public YayinEntity(Long YayinID, String YayinAdi, Long YayinYili) {
        this.yayinID = YayinID;
        this.yayinAdi = YayinAdi;
        this.yayinYili = YayinYili;
    }

    public YayinEntity() {
    }

    public Long getYayinID() {
        return yayinID;
    }

    public String getYayinAdi() {
        return yayinAdi;
    }

    public Long getYayinYili() {
        return yayinYili;
    }

//    public List<TurEntity> getYayinTuru() {
//        return yayinTuru;
//    }
//
//    public List<TurEntity> getYayinYeri() {
//        return yayinYeri;
//    }

    public void setYayinID(Long yayinID) {
        this.yayinID = yayinID;
    }

    public void setYayinAdi(String yayinAdi) {
        this.yayinAdi = yayinAdi;
    }

    public void setYayinYili(Long yayinYili) {
        this.yayinYili = yayinYili;
    }

//    public void setYayinTuru(List<TurEntity> yayinTuru) {
//        this.yayinTuru = yayinTuru;
//    }
//
//    public void setYayinYeri(List<TurEntity> yayinYeri) {
//        this.yayinYeri = yayinYeri;
//    }

}
