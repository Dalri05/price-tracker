package com.joaod.price_tracker.feature.produtos.controller;

import com.joaod.price_tracker.feature.produtos.dto.ProdutoDTO;
import com.joaod.price_tracker.feature.produtos.entity.Produto;
import com.joaod.price_tracker.feature.produtos.service.ProdutoService;
import com.joaod.price_tracker.shared.DTO.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController()
@RequestMapping("/api/v1/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<ResponseDTO<List<ProdutoDTO>>> getProdutosCadastrados() {
        List<ProdutoDTO> produtosDTO = produtoService.getProdutosCadastrados();

        if (Objects.isNull(produtosDTO)) {
            ResponseDTO<List<ProdutoDTO>> response = new ResponseDTO<>(
                    404,
                    "Nenhum produto encontrado.",
                    LocalDateTime.now(),
                    null
            );
            return ResponseEntity.status(404).body(response);
        }

        ResponseDTO<List<ProdutoDTO>> response = new ResponseDTO<>(
                200,
                "Produtos retornados com sucesso.",
                LocalDateTime.now(),
                produtosDTO
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ResponseDTO<ProdutoDTO>> cadastrarProduto(ProdutoDTO produtoDTO) {
        ProdutoDTO produtoCadastrado = produtoService.cadastrarProduto(produtoDTO);

        if (Objects.isNull(produtoCadastrado)) {
            ResponseDTO<ProdutoDTO> response = new ResponseDTO<>(
                    400,
                    "Erro ao cadastrar o produto.",
                    LocalDateTime.now(),
                    null
            );
            return ResponseEntity.status(400).body(response);
        }

        ResponseDTO<ProdutoDTO> response = new ResponseDTO<>(
                201,
                "Produto cadastrado com sucesso.",
                LocalDateTime.now(),
                produtoCadastrado
        );
        return ResponseEntity.status(201).body(response);
    }
}
