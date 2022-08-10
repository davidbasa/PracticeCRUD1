package com.example.practicecrud1.service;

import com.example.practicecrud1.model.Buku;
import com.example.practicecrud1.repo.BukuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Component
public class BukuService {
//service untuk logika
    @Autowired
    BukuRepo bukuRepo;

    public List<Buku> getBuku(){
        return bukuRepo.findAll();
    }

    public Buku getBukubyID(int idbuku){
        return bukuRepo.findById(idbuku).orElseThrow();
    }

    public Buku insertBuku(@Validated @RequestBody Buku newBuku){
        return bukuRepo.save(newBuku);
    }

    public Buku deleteBuku(@Validated int idbuku){
        Buku buku = bukuRepo.findById(idbuku).orElseThrow();
        bukuRepo.delete(buku);
        return buku;
    }

    public Buku updateBuku(int idbuku, @Validated @RequestBody Buku updateBuku){
        Buku buku = bukuRepo.findById(idbuku).orElseThrow();
        //buku.setIdbuku(updateBuku.getIdbuku());
        buku.setNamabuku(updateBuku.getNamabuku());
        Buku bukuBaru = bukuRepo.save(buku);
        return bukuBaru;
    }
}
