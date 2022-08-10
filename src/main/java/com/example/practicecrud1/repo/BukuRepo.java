package com.example.practicecrud1.repo;

import com.example.practicecrud1.model.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BukuRepo extends JpaRepository<Buku,Integer>{
}
