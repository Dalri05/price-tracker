package com.joaod.price_tracker.feature.mercadoLivre.dto;

import com.joaod.price_tracker.feature.mercadoLivre.entity.MercadoLivre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MercadoLivreDTO {
    private Long id;

    private String mlId;

    private String title;

    private float price;

    private String permalink;

    public static MercadoLivreDTO from(MercadoLivre mercadoLivre) {
        return MercadoLivreDTO.builder()
                .id(mercadoLivre.getId())
                .mlId(mercadoLivre.getMlId())
                .title(mercadoLivre.getTitle())
                .price(mercadoLivre.getPrice())
                .permalink(mercadoLivre.getPermalink())
                .build();
    }
}
