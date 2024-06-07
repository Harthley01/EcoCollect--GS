package br.com.fiap.global.repository;

import br.com.fiap.global.entity.ProfissionalPosto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalPostoRepository extends JpaRepository<ProfissionalPosto, Long> {
}
