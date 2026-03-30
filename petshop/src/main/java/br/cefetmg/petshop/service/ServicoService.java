package br.cefetmg.petshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.cefetmg.petshop.model.Servico;
import br.cefetmg.petshop.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository servicoRepository;

    public Servico getServico(Long id){
        Servico servico = servicoRepository.findById(id).orElse(null);
        if (servico == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Informação não encontrada.");
        }
        return servico;
    }

    public List<Servico> getServicoList(){
        return servicoRepository.findAll();
    }

    public Servico insertServico(Servico servico){
        servico.setId(null);
        servicoRepository.save(servico);
        return servico;
    }

    public Servico updateServico(Servico servico){
        if (servico.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Id é obrigatório.");
        }
        servicoRepository.save(servico);
        return servico;
    }

    public Servico deleteServico(Long id){
        Servico servico = this.getServico(id);
        if (servico == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado um servico com o id: " + id);
        }

        servicoRepository.deleteById(id);

        return servico;
    }

}
