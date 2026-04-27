package br.cefetmg.petshop.controller.dto;

import br.cefetmg.petshop.model.security.Token;
import br.cefetmg.petshop.model.security.Usuario;
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
