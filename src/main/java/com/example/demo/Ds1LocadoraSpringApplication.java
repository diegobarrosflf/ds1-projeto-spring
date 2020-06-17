package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Cidade;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Filme;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.CidadeRepository;
import com.example.demo.repositories.EstadoRepository;
import com.example.demo.repositories.FilmeRepository;

@SpringBootApplication
public class Ds1LocadoraSpringApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	FilmeRepository filmeRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Ds1LocadoraSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Ação");
		Categoria cat2 = new Categoria(null, "Terror");
		
		Filme f1 = new Filme(null, "Matrix", 5.00);
		Filme f2 = new Filme(null, "JSON X", 6.00);
		Filme f3 = new Filme(null, "Exterminador do futuro", 7.00);
		
		cat1.getFilmes().addAll(Arrays.asList(f1,f2,f3));
		cat2.getFilmes().addAll(Arrays.asList(f2));
		
		f1.getCategorias().addAll(Arrays.asList(cat1));
		f2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		f3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		filmeRepository.saveAll(Arrays.asList(f1,f2,f3));
		
		Estado est1 = new Estado(null,"Ceará");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade cd1 = new Cidade(null,"Fortaleza", est1);
		Cidade cd2 = new Cidade(null,"São Paulo", est2);
		Cidade cd3 = new Cidade(null,"Lorena", est2);
		
		est1.getCidades().addAll(Arrays.asList(cd1));
		est2.getCidades().addAll(Arrays.asList(cd2,cd3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cd1,cd2,cd3));
		
		
		
		
	}

}
