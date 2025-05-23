package com.joaod.price_tracker.feature.produtos.dto;

import com.joaod.price_tracker.feature.produtos.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoDTO {
    private String nome;

    private Double precoDesejado;

    private Double precoAtual;

    private float percOcilacao;

    private String idInterno;

    public static ProdutoDTO from(Produto produto) {
        return ProdutoDTO.builder()
                .nome(produto.getNome())
                .precoAtual(produto.getPrecoAtual())
                .precoDesejado(produto.getPrecoDesejado())
                .percOcilacao(produto.getPercOcilacao())
                .idInterno(produto.getIdInterno())
                .build();
    }
}
