package br.com.fiap.global.repository;

import br.com.fiap.global.entity.PostoAvancado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostoAvancadoRepository extends JpaRepository<PostoAvancado, Long> {
}
