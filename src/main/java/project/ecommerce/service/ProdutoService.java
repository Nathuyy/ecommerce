package project.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.ecommerce.exception.ResourceNotFoundException;
import project.ecommerce.model.Produto;
import project.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto novProduto) {
        return produtoRepository.save(novProduto);
    }

    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Integer id) {
        if (produtoRepository.existsById(id)) {
            return produtoRepository.findById(id).get();
        } else {
            throw new ResourceNotFoundException("Produto com ID " + id + " não encontrado.");
        }
    }

    public void deletarPorId(Integer id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Produto com ID " + id + " não encontrado.");
        }
    }

    public Produto atualizarProduto(Produto produtoAtualizado) {
        if (produtoRepository.existsById(produtoAtualizado.getId())) {
            return produtoRepository.save(produtoAtualizado);     
        } else {
            throw new ResourceNotFoundException("Produto com ID " + produtoAtualizado.getId() + " não encontrado.");
        }
    }
}
