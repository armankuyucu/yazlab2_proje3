package com.example.yazlab2_proje3;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Tur")
public class TurEntity {
    @Id
    public Long TurID;
    public String YayinTuru;
    public String YayinYeri;

    public TurEntity(Long TurID, String YayinTuru, String YayinYeri){
        this.TurID = TurID;
        this.YayinTuru = YayinTuru;
        this.YayinYeri = YayinYeri;
    }
}
