package project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.ecommerce.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
