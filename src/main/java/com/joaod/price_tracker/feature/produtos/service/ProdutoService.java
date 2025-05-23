package com.joaod.price_tracker.feature.produtos.service;

import com.joaod.price_tracker.feature.produtos.dto.ProdutoDTO;
import com.joaod.price_tracker.feature.produtos.entity.Produto;
import com.joaod.price_tracker.feature.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> getProdutosCadastrados() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produto -> ProdutoDTO.from(produto)).toList();
    }

    public void deleteProdutoById(Long id) {
        produtoRepository.deleteById(id);
    }

    public ProdutoDTO getProdutoById(Long id) {
        Produto produto = produtoRepository.findById(id).orElse(null);
        if (Objects.isNull(produto)) {
            return null;
        }
        return ProdutoDTO.from(produto);
    }

    public ProdutoDTO cadastrarProduto(ProdutoDTO produtoDTO) {
        Produto produto = Produto.builder()
                .nome(produtoDTO.getNome())
                .precoAtual(produtoDTO.getPrecoAtual())
                .precoDesejado(produtoDTO.getPrecoDesejado())
                .percOcilacao(produtoDTO.getPercOcilacao())
                .idInterno(produtoDTO.getIdInterno())
                .build();
        produto = produtoRepository.save(produto);
        return ProdutoDTO.from(produto);
    }


}
