package com.joaod.price_tracker.feature.mercadoLivre.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_mercado_livre_produto")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MercadoLivreProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ml_id", nullable = false, unique = true)
    private String mlId;

    @Column(name = "titulo")
    private String title;

    @Column(name = "preco", nullable = false)
    private float price;

    @Column(name = "link", nullable = false)
    private String permalink;

}
