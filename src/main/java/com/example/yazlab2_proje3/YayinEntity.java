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

    @Relationship(type = "Yayin Turu", direction = Relationship.Direction.INCOMING)
    public List<TurEntity> YayinTuru;

    @Relationship(type = "Yayin Yeri", direction = Relationship.Direction.INCOMING)
    public List<TurEntity> YayinYeri;

    public YayinEntity(Long YayinID, String YayinAdi, Long YayinYili, List<TurEntity> YayinTuru, List<TurEntity> YayinYeri) {
        this.yayinID = YayinID;
        this.yayinAdi = YayinAdi;
        this.yayinYili = YayinYili;
        this.YayinTuru = YayinTuru;
        this.YayinYeri = YayinYeri;
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

    public List<TurEntity> getYayinTuru() {
        return YayinTuru;
    }

    public List<TurEntity> getYayinYeri() {
        return YayinYeri;
    }

    public void setYayinID(Long yayinID) {
        this.yayinID = yayinID;
    }

    public void setYayinAdi(String yayinAdi) {
        this.yayinAdi = yayinAdi;
    }

    public void setYayinYili(Long yayinYili) {
        this.yayinYili = yayinYili;
    }

    public void setYayinTuru(List<TurEntity> yayinTuru) {
        YayinTuru = yayinTuru;
    }

    public void setYayinYeri(List<TurEntity> yayinYeri) {
        YayinYeri = yayinYeri;
    }

}
