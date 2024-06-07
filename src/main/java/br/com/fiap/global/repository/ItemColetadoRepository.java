package br.com.fiap.global.repository;

import br.com.fiap.global.entity.ItemColetado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemColetadoRepository extends JpaRepository<ItemColetado, Long> {
}
