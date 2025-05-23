package com.joaod.price_tracker.feature.produtos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_produto")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco_desejado", nullable = false)
    private Double precoDesejado;

    @Column(name = "preco_atual")
    private Double precoAtual;

    @Column(name = "porcentagem_ocilacacao")
    private float percOcilacao;

    @Column(name = "id_interno", nullable = false)
    private String idInterno;

}
