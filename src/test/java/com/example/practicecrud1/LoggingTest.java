package com.example.practicecrud1;


import com.example.practicecrud1.controller.BukuController;
import com.example.practicecrud1.model.Buku;
import com.example.practicecrud1.repo.BukuRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootTest
@TestPropertySource("classpath:application.properties")
public class LoggingTest {
    @Autowired
    BukuRepo bukuRepo;
    @Autowired
    BukuController bukuController;

    @Test
    public void saveBukuTest(){
        for(int i = 0; i<10;i++){
        Buku buku = Buku.builder()
                .idbuku(10)
                .namabuku("cie nyari lagi")
                .build();
        bukuRepo.save(buku);
        Assertions.assertEquals(buku.getNamabuku(), "cie nyari lagi");
        }
    }

    @Test
    public void getBukuTest(){
        for(int i = 0; i<10;i++) {
            bukuRepo.findAll();
            ResponseEntity<List<Buku>> response = bukuController.getBukus();
            Assertions.assertEquals(HttpStatus.FOUND, response.getStatusCode());
        }
    }

    @Test
    public void getBukubuIDTest(){
        for(int i = 0; i<10;i++) {
            Buku buku = bukuRepo.findById(2).get();
            Assertions.assertEquals(buku.getNamabuku(), "hayo belum ketemu");
        }
    }

    @Test
    public void deleteBukuTest(){
        for(int i = 0; i<10;i++) {
            Buku buku = bukuRepo.findById(10).get();
            bukuRepo.delete(buku);

            Buku buku1 = null;

            Optional<Buku> optionalBuku = bukuRepo.findById(10);

            if (optionalBuku.isPresent()) {
                buku1 = optionalBuku.get();
            }

            Assertions.assertNull(buku1);
        }
    }

    @Test
    public void updateBukuTest(){
        for(int i = 0; i<10;i++) {
            Buku buku = bukuRepo.findById(5).get();

            buku.setNamabuku("blabalabla sudah dirubah");

            Buku bukuUpdated = bukuRepo.save(buku);

            Assertions.assertEquals(bukuUpdated.getNamabuku(), "blabalabla sudah dirubah");
        }

    }


}
