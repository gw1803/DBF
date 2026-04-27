package br.gabriel.conta.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gabriel.conta.model.Pagante;
import br.gabriel.conta.service.PaganteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/pagantes")
@RequiredArgsConstructor
public class PaganteController {

    public final PaganteService paganteService;

    @GetMapping("/{id}")
    public ResponseEntity<Pagante> getPagante(@PathVariable Long id){
        Pagante pagante = paganteService.getPagante(id);
        return ResponseEntity.ok().body(pagante);
    }

    @GetMapping("")
    public ResponseEntity<List<Pagante>> getPaganteList(){
        return ResponseEntity.ok().body(paganteService.getPaganteList());
    }

    @PostMapping("")
    public ResponseEntity<Pagante> insertPagante(@RequestBody Pagante pagante){
        Pagante paganteAux = paganteService.insertPagante(pagante);
        return ResponseEntity.ok().body(paganteAux);
    }

    @PutMapping("")
    public ResponseEntity<Pagante> updatePagante(@RequestBody Pagante pagante){
        Pagante paganteAux = paganteService.updatePagante(pagante);
        return ResponseEntity.ok().body(paganteAux);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pagante> deletePagante(@PathVariable Long id){
        Pagante paganteAux = paganteService.deletePagante(id);
        return ResponseEntity.ok().body(paganteAux);
    }
}
