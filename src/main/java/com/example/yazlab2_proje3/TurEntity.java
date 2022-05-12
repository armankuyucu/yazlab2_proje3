package com.example.yazlab2_proje3;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Tur")
public class TurEntity {
    @Id @GeneratedValue
    public Long turID;

    public String yayinTuru;
    public String yayinYeri;

    public TurEntity(Long TurID, String YayinTuru, String YayinYeri) {
        this.turID = TurID;
        this.yayinTuru = YayinTuru;
        this.yayinYeri = YayinYeri;
    }

    public TurEntity() {
    }

    public Long getTurID() {
        return turID;
    }

    public void setTurID(Long turID) {
        this.turID = turID;
    }

    public String getYayinTuru() {
        return yayinTuru;
    }

    public void setYayinTuru(String yayinTuru) {
        this.yayinTuru = yayinTuru;
    }

    public String getYayinYeri() {
        return yayinYeri;
    }

    public void setYayinYeri(String yayinYeri) {
        this.yayinYeri = yayinYeri;
    }

}
