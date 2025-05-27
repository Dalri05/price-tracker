package com.joaod.price_tracker.feature.mercadoLivre.repository;

import com.joaod.price_tracker.feature.mercadoLivre.entity.MercadoLivreProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercadoLivreRepository extends JpaRepository<MercadoLivreProduct, Long> {
}
