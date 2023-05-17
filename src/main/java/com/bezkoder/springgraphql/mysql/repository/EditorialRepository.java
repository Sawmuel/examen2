package com.bezkoder.springgraphql.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springgraphql.mysql.model.Editorial;

public interface EditorialRepository extends JpaRepository<Editorial, Long> {
    
}
