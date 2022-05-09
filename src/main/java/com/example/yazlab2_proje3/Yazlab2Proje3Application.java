package com.example.yazlab2_proje3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Yazlab2Proje3Application implements CommandLineRunner {

    private final ArastirmaciRepository arastirmaciRepository;

    public Yazlab2Proje3Application(ArastirmaciRepository arastirmaciRepository) {
        this.arastirmaciRepository = arastirmaciRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Yazlab2Proje3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        for(ArastirmaciEntity arastirmaci : arastirmaciRepository.findAll()){
//            System.out.println(arastirmaci.getArastirmaciAdi());
//        }
    }
}
