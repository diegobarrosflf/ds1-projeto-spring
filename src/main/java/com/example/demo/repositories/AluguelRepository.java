package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Integer>{

}
