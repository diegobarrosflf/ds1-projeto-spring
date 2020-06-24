package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Aluguel;
import com.example.demo.domain.Categoria;
import com.example.demo.domain.Cidade;
import com.example.demo.domain.Cliente;
import com.example.demo.domain.Endereco;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Filme;
import com.example.demo.domain.ItemAluguel;
import com.example.demo.domain.Pagamento;
import com.example.demo.domain.PagamentoBoleto;
import com.example.demo.domain.PagamentoCredito;
import com.example.demo.domain.enums.EstadoPagamento;
import com.example.demo.domain.enums.TipoCliente;
import com.example.demo.repositories.AluguelRepository;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.CidadeRepository;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.EnderecoRepository;
import com.example.demo.repositories.EstadoRepository;
import com.example.demo.repositories.FilmeRepository;
import com.example.demo.repositories.ItemAluguelRepository;
import com.example.demo.repositories.PagamentoRepository;

@SpringBootApplication
public class Ds1LocadoraSpringApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	FilmeRepository filmeRepository;

	@Autowired
	CidadeRepository cidadeRepository;

	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	AluguelRepository aluguelRepository;

	@Autowired
	PagamentoRepository pagamentoRepository;
	
	@Autowired
	ItemAluguelRepository itemAluguelRepository;

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

		cat1.getFilmes().addAll(Arrays.asList(f1, f2, f3));
		cat2.getFilmes().addAll(Arrays.asList(f2));

		f1.getCategorias().addAll(Arrays.asList(cat1));
		f2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		f3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		filmeRepository.saveAll(Arrays.asList(f1, f2, f3));

		Estado est1 = new Estado(null, "Ceará");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade cd1 = new Cidade(null, "Fortaleza", est1);
		Cidade cd2 = new Cidade(null, "São Paulo", est2);
		Cidade cd3 = new Cidade(null, "Lorena", est2);

		est1.getCidades().addAll(Arrays.asList(cd1));
		est2.getCidades().addAll(Arrays.asList(cd2, cd3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cd1, cd2, cd3));

		Cliente cli1 = new Cliente(null, "Jose Ribeiro", "jose@mial.com", "32165498-87", TipoCliente.PESSOA_FISICA);
		Cliente cli2 = new Cliente(null, "Maria Barbosa", "maria@mial.com", "654987321-59",
				TipoCliente.PESSOA_JURIDICA);

		Endereco end1 = new Endereco(null, "Rua 13 de maio", "235", "casa", "Bela Vista", "32165454", cli1, cd1);
		Endereco end2 = new Endereco(null, "Rua Silva Bueno", "222", "Ap", "Ipiranga", "65498721", cli2, cd2);

		cli1.getEndrecos().addAll(Arrays.asList(end1));
		cli1.getTelefones().addAll(Arrays.asList("3213-6544", "6546-9887"));

		cli2.getEndrecos().addAll(Arrays.asList(end2));
		cli2.getTelefones().addAll(Arrays.asList("3214-9875", "9514-7536"));

		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm");
		
		Aluguel a1 = new Aluguel(null, sdf.parse("17/06/2020 21:10"), cli1, end1);
		Aluguel a2 = new Aluguel(null,sdf.parse("18/06/2020 08:10"), cli2, end2);
		
		Pagamento pag1 = new PagamentoCredito(null, EstadoPagamento.QUITADO, a1, 6);
		Pagamento pag2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, a2, sdf.parse("19/06/2020 08:00"), null);
		
		a1.setPagamento(pag1);
		a2.setPagamento(pag2);
		
		aluguelRepository.saveAll(Arrays.asList(a1,a2));
		pagamentoRepository.saveAll(Arrays.asList(pag1,pag2));
		
		ItemAluguel il1 = new ItemAluguel(a1,f1,0,1);
		ItemAluguel il2 = new ItemAluguel(a2,f2,0,1);
		ItemAluguel il3 = new ItemAluguel(a2,f3,0,1);
		
		a1.getItens().add(il1);
		a2.getItens().addAll(Arrays.asList(il2,il3));
		
		f1.getItens().addAll(Arrays.asList(il1));
		f2.getItens().addAll(Arrays.asList(il2));
		f3.getItens().addAll(Arrays.asList(il3));
		
		itemAluguelRepository.saveAll(Arrays.asList(il1,il2,il3));
		
 
	}

}

