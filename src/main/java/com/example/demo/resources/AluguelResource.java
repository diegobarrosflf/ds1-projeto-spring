package com.example.demo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Aluguel;
import com.example.demo.services.AluguelService;

@RestController
@RequestMapping(value = "/alugueis")
public class AluguelResource {

	@Autowired
	private AluguelService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluguel> find(@PathVariable Integer id) {
		Aluguel obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}