package com.joaod.price_tracker.feature.mercadoLivre.service;

import com.joaod.price_tracker.feature.mercadoLivre.client.MercadoLivreClient;
import com.joaod.price_tracker.feature.mercadoLivre.model.MercadoLivreProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MercadoLivreService {
    @Autowired
    private MercadoLivreClient mercadoLivreClient;

    public MercadoLivreProductModel getProdutoByMlId(String id) {
        MercadoLivreProductModel produto = null;
        try {
            produto = mercadoLivreClient.consultarProdutoPorId(id).block();
            if (Objects.nonNull(produto)) return produto;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao consultar produto no Mercado Livre: " + e.getMessage());
        } finally {
            return produto;
        }
    }

    public List<MercadoLivreProductModel> getProdutosByMlId(List<String> ids) {
        List<MercadoLivreProductModel> produtos = new ArrayList<>();
        try {
            for (String id : ids) {
                MercadoLivreProductModel produto = mercadoLivreClient.consultarProdutoPorId(id).block();
                if (Objects.nonNull(produto)) {
                    produtos.add(produto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao consultar produtos no Mercado Livre: " + e.getMessage());
        } finally {
            return produtos;
        }
    }
}
