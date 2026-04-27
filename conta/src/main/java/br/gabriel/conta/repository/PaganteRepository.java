package br.gabriel.conta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.gabriel.conta.model.Pagante;

@Repository
public interface PaganteRepository extends JpaRepository<Pagante, Long> {

    List<Pagante> findByNomeContaining(String nome);

}
