package com.example.practicecrud1;


import com.example.practicecrud1.controller.BukuController;
import com.example.practicecrud1.model.Buku;
import com.example.practicecrud1.repo.BukuRepo;
import com.example.practicecrud1.service.BukuService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class BukuTestMock {

    @Mock
    private BukuRepo bukuRepo;

    @InjectMocks
    private BukuService bukuService;

    @InjectMocks
    private BukuController bukuController;

    @Test
    public void saveBukuTest(){
        Buku buku = new Buku();
        buku.setIdbuku(11);
        buku.setNamabuku("ini yg terakhir");

        when(bukuRepo.save(any(Buku.class))).thenReturn(buku);

        Buku savedBuku = bukuRepo.save(buku);
        Assertions.assertNotNull(savedBuku.getIdbuku());
    }

    @Test
    public void getAllBukuTest(){
        List<Buku> buku = new ArrayList<>();

        when(bukuService.getBuku()).thenReturn(buku);

        ResponseEntity<List<Buku>> response = bukuController.getBukus();
        Assertions.assertEquals(HttpStatus.FOUND, response.getStatusCode());
    }

}
