package com.joaod.price_tracker.feature.mercadoLivre.service;

import com.joaod.price_tracker.feature.mercadoLivre.entity.MercadoLivreProduct;
import com.joaod.price_tracker.feature.mercadoLivre.repository.MercadoLivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MercadoLivreService {
    @Autowired
    private MercadoLivreRepository mercadoLivreRepository;

    public List<MercadoLivreProduct> findAll() {
        return mercadoLivreRepository.findAll();
    }
}
