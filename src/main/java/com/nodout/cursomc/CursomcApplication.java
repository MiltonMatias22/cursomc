package com.nodout.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nodout.cursomc.domain.Categoria;
import com.nodout.cursomc.domain.Cidade;
import com.nodout.cursomc.domain.Cliente;
import com.nodout.cursomc.domain.Endereco;
import com.nodout.cursomc.domain.Estado;
import com.nodout.cursomc.domain.Pagamento;
import com.nodout.cursomc.domain.PagamentoComBoleto;
import com.nodout.cursomc.domain.PagamentoComCartao;
import com.nodout.cursomc.domain.Pedido;
import com.nodout.cursomc.domain.Produto;
import com.nodout.cursomc.domain.enums.EstadoPagamento;
import com.nodout.cursomc.domain.enums.TipoCliente;
import com.nodout.cursomc.repositoreis.CategoriaRepository;
import com.nodout.cursomc.repositoreis.CidadeRepository;
import com.nodout.cursomc.repositoreis.ClienteRepository;
import com.nodout.cursomc.repositoreis.EnderecoRepository;
import com.nodout.cursomc.repositoreis.EstadoRepository;
import com.nodout.cursomc.repositoreis.PagamentoRepository;
import com.nodout.cursomc.repositoreis.PedidoRepository;
import com.nodout.cursomc.repositoreis.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	/** DEPENDÊNCIAS */
	@Autowired
	private CategoriaRepository categoriaRepository;
	
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		/** INTANCIAÇÃO DE OBJETOS DO SISTEMA */
		
		/** --- Produto e Categoria ---*/
		
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
		
		/** SALVANDO */
		categoriaRepository.save(Arrays.asList(categoria1, categoria2));
		
		produtoRepository.save(Arrays.asList(produto1, produto2, produto3));
		
		/** --- Estado e Cidade ---*/		

		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "São Paulo");
		
		Cidade cidade1 = new Cidade(null, "Uberlâbdia", estado1);
		Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
		Cidade cidade3 = new Cidade(null, "Campinas", estado2);
		
		/** Associando cidades aos estados por meio da adição
		 *  de cidades a lista de cidades da classe Estado. 
		 */
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		/** SALVANDO */
		estadoRepository.save(Arrays.asList(estado1, estado2));
		
		cidadeRepository.save(Arrays.asList(cidade1, cidade2, cidade3));
		
		/** Cliente, Telefone e Endereco,*/
		
		Cliente cliente1 = new Cliente(null, "Milton Matias", "milton@gmail.com", "111222333-20", TipoCliente.PESSOA_FISICA);
		//add telefones ao cliente
		cliente1.getTelefones().addAll(Arrays.asList("982664367","53220000"));
		
		Endereco endereco1 = new Endereco(null, "Magno de Araújo", "2343", "praça nazare",
				"São Lourenço", "68440000", cliente1, cidade1);
		Endereco endereco2 = new Endereco(null, "Conselheiro Furtado", "380", "Esq. com Tv. tupinambás",
				"Batista Campus", "66025160", cliente1, cidade2);
		
		//add endereços ao cliente
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));	
		
		/** SALVANDO */
		clienteRepository.save(Arrays.asList(cliente1));
		
		enderecoRepository.save(Arrays.asList(endereco1, endereco2));
		
		/** */
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido pedido1 = new Pedido(null, format.parse("30/09/2017 10:32"), cliente1, endereco1);
		Pedido pedido2 = new Pedido(null, format.parse("10/10/2017 19:32"), cliente1, endereco2);
		
		Pagamento pagamento1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO,
				pedido1, 6);
		// add pagamento ao pedido
		pedido1.setPagamento(pagamento1);
		
		Pagamento pagamento2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE,
				pedido2, format.parse("20/19/2017 10:32"), null);
		// add pagamento ao pedido
		pedido2.setPagamento(pagamento2);
		
		// Add pedido ao cliente
		cliente1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));
		
		/** SALVANDO */
		pedidoRepository.save(Arrays.asList(pedido1, pedido2));
		
		pagamentoRepository.save(Arrays.asList(pagamento1, pagamento2));		
	}
	
}
