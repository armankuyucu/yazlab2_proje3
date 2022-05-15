package com.example.yazlab2_proje3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/userPanel","/","/results","arastirmaci-sonuc","yayin-sonuc","tur-sonuc",
                "/adminPanel/arastirmaciYayinRelationship","/adminPanel/arastirmaciColleague","/adminPanel/yayin",
                "/adminPanel/tur", "/adminPanel/arastirmaci","/adminPanel/yayinTurRelationship");
         }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();// We don't need sessions to be created.
//    }

}