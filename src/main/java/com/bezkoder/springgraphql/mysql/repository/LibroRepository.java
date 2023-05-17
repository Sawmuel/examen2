package com.bezkoder.springgraphql.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springgraphql.mysql.model.Libro;

public interface LibroRepository extends JpaRepository <Libro, Long>{
    
}
