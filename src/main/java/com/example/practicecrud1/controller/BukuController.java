package com.example.practicecrud1.controller;

import com.example.practicecrud1.model.Buku;
import com.example.practicecrud1.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
@Controller
public class BukuController {
//controller untuk nerima fe
    @Autowired
    BukuService bukuService;


    @RequestMapping("/")
    public String home(){
        return("<h1>welcome</h1>");
    }

    //getAll
    @GetMapping("/buku")
    public ResponseEntity<List<Buku>> getBukus(){
        try {
            List<Buku> bukus = bukuService.getBuku();
            return new ResponseEntity<List<Buku>>(bukus,HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getByID
    @GetMapping("/buku/{idbuku}")
    public ResponseEntity<Buku> getBukuByID(@PathVariable(value = "idbuku")int idbuku){
        try {
            Buku buku = bukuService.getBukubyID(idbuku);
            return new ResponseEntity<Buku>(buku,HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //insert
    @PostMapping("/buku")
    public ResponseEntity<Buku> insertBuku(@Validated @RequestBody Buku buku){
        try {
            Buku bukuInsert = bukuService.insertBuku(buku);
            return new ResponseEntity<Buku>(bukuInsert,HttpStatus.CREATED);//created 201
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/buku/{idbuku}")
    @ResponseBody
    public ResponseEntity<Buku> deleteBuku(@Validated @PathVariable(value = "idbuku")int idbuku){
        try {
            Buku bukuDelete = bukuService.deleteBuku(idbuku);
            return new ResponseEntity<>(bukuDelete,HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/buku/{idbuku}")
    public ResponseEntity<Buku> updateBuku(@PathVariable(value = "idbuku") int idbuku,@Validated @RequestBody Buku updateBuku){
        try {
            Buku bukuUpdate = bukuService.updateBuku(idbuku,updateBuku);
            return new ResponseEntity<>(bukuUpdate,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
      }

}