package com.cardapiodigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardapiodigital.model.Pizza;

public interface CardapioRepository extends JpaRepository<Pizza, Long> {

}
