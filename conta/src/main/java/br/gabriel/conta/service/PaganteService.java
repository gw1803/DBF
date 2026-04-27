package br.gabriel.conta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gabriel.conta.model.Pagante;
import br.gabriel.conta.repository.PaganteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaganteService {

    private final PaganteRepository paganteRepository;

    public Pagante getPagante(Long id){
        Pagante pagante = paganteRepository.findById(id).orElse(null);
        if (pagante == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Informação não encontrada.");
        }
        return pagante;
    }

    public List<Pagante> getPaganteList(){
        return paganteRepository.findAll();
    }

    public Pagante insertPagante(Pagante pagante){
        pagante.setId(null);
        paganteRepository.save(pagante);
        return pagante;
    }

    public Pagante updatePagante(Pagante pagante){
        if (pagante.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Id é obrigatório.");
        }
        paganteRepository.save(pagante);
        return pagante;
    }

    public Pagante deletePagante(Long id){
        Pagante pagante = this.getPagante(id);
        if (pagante == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado um pagante com o id: " + id);
        }

        paganteRepository.deleteById(id);

        return pagante;
    }

}
