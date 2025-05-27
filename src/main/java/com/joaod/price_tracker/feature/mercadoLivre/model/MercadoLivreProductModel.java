package com.joaod.price_tracker.feature.mercadoLivre.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MercadoLivreProductModel {

    private String mlId;

    private String title;

    private float price;

    private String permalink;

}
