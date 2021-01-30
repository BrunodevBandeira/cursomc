package com.brunobandeira.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brunobandeira.cursomc.domain.Categoria;
import com.brunobandeira.cursomc.domain.Cidade;
import com.brunobandeira.cursomc.domain.Cliente;
import com.brunobandeira.cursomc.domain.Endereco;
import com.brunobandeira.cursomc.domain.Estado;
import com.brunobandeira.cursomc.domain.Produto;
import com.brunobandeira.cursomc.domain.enums.TipoCliente;
import com.brunobandeira.cursomc.repositories.CategoriaRepository;
import com.brunobandeira.cursomc.repositories.CidadeRepository;
import com.brunobandeira.cursomc.repositories.ClienteRepository;
import com.brunobandeira.cursomc.repositories.EnderecoRepository;
import com.brunobandeira.cursomc.repositories.EstadoRepository;
import com.brunobandeira.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepositori;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		Estado est1 = new Estado(null, "Minas gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c3, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		//categoriaRepositori.saveAll(Arrays.asList(cat1, cat2));
		//produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "Maria@gmail.com", 
				"121212121212", TipoCliente.PESSOAFISICA);
		
		
		cli1.getTelefones().addAll(Arrays.asList("124578", "98989898")); 
		Endereco e1 = new Endereco(null, "Rua floes", "300", "Apt 300", "Jardim", "36985214", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua matos", "105", "Apt 800", "Centro", "4569878888", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
	}
}
