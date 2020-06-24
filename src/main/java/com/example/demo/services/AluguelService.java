package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Aluguel;
import com.example.demo.repositories.AluguelRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;

@Service
public class AluguelService {

	@Autowired
	private AluguelRepository repository;
	
	public Aluguel find(Integer id) {
		Optional<Aluguel> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Aluguel.class.getName()));
	}

}
