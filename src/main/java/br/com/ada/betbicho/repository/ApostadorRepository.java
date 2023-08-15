package br.com.ada.betbicho.repository;

import br.com.ada.betbicho.entity.Apostador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApostadorRepository extends JpaRepository<Apostador, Long> {
    Optional<Apostador> findByNome(String nome);
}
