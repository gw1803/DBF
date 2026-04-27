package br.gabriel.conta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "conta_pagante")
public class ContaPagante {

    @EmbeddedId
    private ContaPaganteId id = new ContaPaganteId();

    @ManyToOne
    @MapsId("idConta")
    private Conta conta;

    @ManyToOne
    @MapsId("idPagante")
    private Pagante pagante;

    @Column(nullable = true)
    private BigDecimal valor;

    @Column(nullable = true)
    private BigDecimal qntdGasta;

}
