package project.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.ecommerce.model.Produto;
import project.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/novoProduto")
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto){ //ResponseEntity<Produto> indica que a resposta da requisição vai ser do tipo Produto
        Produto novoProduto = produtoService.salvarProduto(produto);
        return ResponseEntity.ok(novoProduto); //.ok indica status 200 e inclui o novo produto
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodosProdutos(){
        return ResponseEntity.ok(produtoService.buscarTodosProdutos());
    }

    @GetMapping("buscarProduto/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @DeleteMapping("/deletarProduto/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Integer id){
        produtoService.deletarPorId(id);
        return ResponseEntity.ok("Produto com ID " + id + " foi deletado com sucesso.");
    }

       @PutMapping("/atualizarProduto")
    public ResponseEntity<String> atualizarProduto(@RequestBody Produto produto) {
        Produto produtoAtualizado = produtoService.atualizarProduto(produto);
        if (produtoAtualizado != null) {
            return ResponseEntity.ok("Produto com ID " + produto.getId() + " foi atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}