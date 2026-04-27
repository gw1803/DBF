package br.gabriel.conta.controller.dto;

import br.gabriel.conta.model.security.Token;
import br.gabriel.conta.model.security.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private Token token;
    private Usuario usuario;
}
