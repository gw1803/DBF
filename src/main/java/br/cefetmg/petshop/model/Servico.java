package br.cefetmg.petshop.model;

import java.math.BigDecimal;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "servico") 
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 20, nullable = false, unique = false)
    private String nome;

    @Column(name = "valor", precision = 10, scale = 2, nullable = false, unique = false)
    private BigDecimal valor;

}
