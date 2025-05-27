package com.joaod.price_tracker.feature.mercadoLivre.dto;

import com.joaod.price_tracker.feature.mercadoLivre.entity.MercadoLivreProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MercadoLivreProductDTO {
    private Long id;

    private String mlId;

    private String title;

    private float price;

    private String permalink;

    public static MercadoLivreProductDTO from(MercadoLivreProduct mercadoLivreProduct) {
        return MercadoLivreProductDTO.builder()
                .id(mercadoLivreProduct.getId())
                .mlId(mercadoLivreProduct.getMlId())
                .title(mercadoLivreProduct.getTitle())
                .price(mercadoLivreProduct.getPrice())
                .permalink(mercadoLivreProduct.getPermalink())
                .build();
    }
}
