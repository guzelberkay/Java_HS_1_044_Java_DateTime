package com.berkay.entity;

import java.time.LocalTime;

public class UserProfile extends BaseEntity{
    Long id;
    String ad;
    String adres;
    String telefon;

    public UserProfile(Long id, String ad, String adres, String telefon) {
        this.id = id;
        this.ad = ad;
        this.adres = adres;
        this.telefon = telefon;
    }

    public UserProfile(long createAt, long updateAt, int state, Long id, String ad, String adres, String telefon) {

        this.id = id;
        this.ad = ad;
        this.adres = adres;
        this.telefon = telefon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
