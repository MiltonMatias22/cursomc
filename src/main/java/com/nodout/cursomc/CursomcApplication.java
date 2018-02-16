package com.nodout.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nodout.cursomc.domain.Categoria;
import com.nodout.cursomc.domain.Produto;
import com.nodout.cursomc.repositoreis.CategoriaRepository;
import com.nodout.cursomc.repositoreis.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria categoria1 = new Categoria(null, "INFORMÁTICA");
		Categoria categoria2 = new Categoria(null, "ESCRITÓRIO");
		
		Produto produto1 = new Produto(null, "Computador", 2000.0);
		Produto produto2 = new Produto(null, "Impressora", 800.0);
		Produto produto3 = new Produto(null, "Mouse", 80.0);
		
		/** Associando produtos as categorias por meio da adicição
		 *  de produtos a lista de produtos da classe Categoria.
		 */
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));
		
		/** Associando categorias aos produtos por meio da adição
		 *  de categorias a lista de categorias da classe Produto. 
		 */
		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria2));

		categoriaRepository.save(Arrays.asList(categoria1, categoria2));
		
		produtoRepository.save(Arrays.asList(produto1, produto2, produto3));
		
	}
	
}
