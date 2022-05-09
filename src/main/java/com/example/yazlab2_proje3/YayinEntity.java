package com.example.yazlab2_proje3;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node("Yayin")
public class YayinEntity {
    @Id
    public Long YayinID;
    public String YayinAdi;
    public Long YayinYili;

    @Relationship(type = "Yayin Turu", direction = Relationship.Direction.INCOMING)
    public List<TurEntity> YayinTuru;

    @Relationship(type = "Yayin Yeri", direction = Relationship.Direction.INCOMING)
    public List<TurEntity> YayinYeri;

    public YayinEntity(Long YayinID, String YayinAdi, Long YayinYili, List<TurEntity> YayinTuru, List<TurEntity> YayinYeri){
        this.YayinID = YayinID;
        this.YayinAdi = YayinAdi;
        this.YayinYili = YayinYili;
        this.YayinTuru = YayinTuru;
        this.YayinYeri = YayinYeri;
    }

    public Long getYayinID(){
        return YayinID;
    }

    public String getYayinAdi(){
        return YayinAdi;
    }

    public Long getYayinYili(){
        return YayinYili;
    }

    public List<TurEntity> getYayinTuru() {
        return YayinTuru;
    }

    public List<TurEntity> getYayinYeri() {
        return YayinYeri;
    }

}
