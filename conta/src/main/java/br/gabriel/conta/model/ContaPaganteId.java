package br.gabriel.conta.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ContaPaganteId implements Serializable {
    private Long idConta;
    private Long idPagante;

}
