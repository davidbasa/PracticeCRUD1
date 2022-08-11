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
        Buku buku = Buku.builder()
                .idbuku(9)
                .namabuku("cie nyari lagi")
                .build();
        bukuRepo.save(buku);
        Assertions.assertEquals(buku.getNamabuku(), "cie nyari lagi");
        log.warn("berhasil simpan");
    }

    @Test
    public void getBukuTest(){
            bukuRepo.findAll();
            ResponseEntity<List<Buku>> response = bukuController.getBukus();
            Assertions.assertEquals(HttpStatus.FOUND, response.getStatusCode());
        log.info("berhasil menampilkan buku");
    }

    @Test
    public void getBukubuIDTest(){
            Buku buku = bukuRepo.findById(2).get();
            Assertions.assertEquals(buku.getNamabuku(), "hayo belum ketemu");
        log.info("berhasil menampilkan buku");

    }

    @Test
    public void deleteBukuTest(){
            Buku buku = bukuRepo.findById(10).get();
            bukuRepo.delete(buku);

            Buku buku1 = null;

            Optional<Buku> optionalBuku = bukuRepo.findById(10);

            if (optionalBuku.isPresent()) {
                buku1 = optionalBuku.get();
            }

            Assertions.assertNull(buku1);
        log.info("berhasil menghapus buku");

    }

    @Test
    public void updateBukuTest(){
            Buku buku = bukuRepo.findById(5).get();

            buku.setNamabuku("blabalabla sudah dirubah");

            Buku bukuUpdated = bukuRepo.save(buku);

            Assertions.assertEquals(bukuUpdated.getNamabuku(), "blabalabla sudah dirubah");
        log.info("berhasil merubah buku");


    }


}
