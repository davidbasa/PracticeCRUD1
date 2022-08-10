package com.example.practicecrud1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="buku")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties
@Builder
public class Buku {
    @Id
    int idbuku;
    String namabuku;

    public Buku(int idbuku, String namabuku) {
        this.idbuku = idbuku;
        this.namabuku = namabuku;
    }

    public Buku() {

    }

    public int getIdbuku() {
        return idbuku;
    }

    public void setIdbuku(int idbuku) {
        this.idbuku = idbuku;
    }

    public String getNamabuku() {
        return namabuku;
    }

    public void setNamabuku(String namabuku) {
        this.namabuku = namabuku;
    }

}
