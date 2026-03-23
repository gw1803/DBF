package br.cefetmg.petshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cefetmg.petshop.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

    List<Servico> findByNomeContaining(String nome);

}
