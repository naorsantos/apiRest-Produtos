package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.model.Produtos;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Produtos> listaProduto(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produtos/{id}")
	@ApiOperation(value="Retorna um produto unico")
	public Produtos findByID(@PathVariable(value="id")long id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produtos")
	@ApiOperation(value="Salva um produto")
		public Produtos salvarProduto(@RequestBody Produtos produto) {
			return produtoRepository.save(produto);
		}
	
	@DeleteMapping("/produtos")
	@ApiOperation(value="Deleta um produto do banco")
	public void deletaProduto(@RequestBody Produtos produto) {
		produtoRepository.delete(produto);
		}
	
	@PutMapping("/produtos")
	@ApiOperation(value="Atualiza um produto")
	public Produtos atualizaProdutos(@RequestBody Produtos produto) {
		return produtoRepository.save(produto);
	}
	
}
