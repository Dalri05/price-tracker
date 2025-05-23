package com.joaod.price_tracker.feature.produtos.repository;

import com.joaod.price_tracker.feature.produtos.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}