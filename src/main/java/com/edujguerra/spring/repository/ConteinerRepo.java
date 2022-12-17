package com.edujguerra.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edujguerra.spring.model.Conteiner;


public interface ConteinerRepo extends JpaRepository<Conteiner, Long> {

}
