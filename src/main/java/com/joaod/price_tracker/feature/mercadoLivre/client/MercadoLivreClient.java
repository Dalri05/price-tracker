package com.joaod.price_tracker.feature.mercadoLivre.client;

import com.joaod.price_tracker.feature.mercadoLivre.model.MercadoLivreProductModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class MercadoLivreClient {

    @Value("${application.mercadolivre.client.url}")
    private String URL_BASE;

    private WebClient webClient;

    public MercadoLivreClient() {
        this.webClient = WebClient.builder()
                .baseUrl(URL_BASE)
                .build();
    }

    public Mono<MercadoLivreProductModel> consultarProdutoPorId(String idProdutoMl) {
        return webClient
                .get()
                .uri("/items/{id}", idProdutoMl)
                .retrieve()
                .bodyToMono(MercadoLivreProductModel.class)
                .doOnNext(produto ->
                        log.info("Produto encontrado no ML: {} por R${}", produto.getTitle(), produto.getPrice())
                )
                .onErrorResume(error -> {
                    log.error("Erro ao consultar produto na API ML: {}", error.getMessage());
                    return Mono.justOrEmpty(null);
                });
    }
}
