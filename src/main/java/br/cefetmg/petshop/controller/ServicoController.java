package br.cefetmg.petshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cefetmg.petshop.model.Servico;
import br.cefetmg.petshop.service.ServicoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/servicos")
@RequiredArgsConstructor
public class ServicoController {

    public final ServicoService servicoService;

    @GetMapping("/{id}")
    public ResponseEntity<Servico> getServico(@PathVariable Long id){
        Servico servico = servicoService.getServico(id);
        return ResponseEntity.ok().body(servico);
    }

    @GetMapping("")
    public ResponseEntity<List<Servico>> getServicoList(){
        return ResponseEntity.ok().body(servicoService.getServicoList());
    }

    @PostMapping("")
    public ResponseEntity<Servico> insertServico(@RequestBody Servico servico){
        Servico servicoAux = servicoService.insertServico(servico);
        return ResponseEntity.ok().body(servicoAux);
    }

    @PutMapping("")
    public ResponseEntity<Servico> updateServico(@RequestBody Servico servico){
        Servico servicoAux = servicoService.updateServico(servico);
        return ResponseEntity.ok().body(servicoAux);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Servico> deleteServico(@PathVariable Long id){
        Servico servicoAux = servicoService.deleteServico(id);
        return ResponseEntity.ok().body(servicoAux);
    }
}
