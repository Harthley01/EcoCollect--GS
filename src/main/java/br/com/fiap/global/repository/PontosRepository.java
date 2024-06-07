package br.com.fiap.global.repository;

import br.com.fiap.global.entity.Pontos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontosRepository extends JpaRepository<Pontos, Long> {
}
