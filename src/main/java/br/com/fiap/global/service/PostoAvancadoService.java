package br.com.fiap.global.service;

import br.com.fiap.global.dto.request.PostoAvancadoRequest;
import br.com.fiap.global.dto.response.PostoAvancadoResponse;
import br.com.fiap.global.entity.PostoAvancado;
import br.com.fiap.global.repository.PostoAvancadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostoAvancadoService implements ServiceDTO<PostoAvancado, PostoAvancadoRequest, PostoAvancadoResponse> {

    @Autowired
    private PostoAvancadoRepository repo;

    @Override
    public PostoAvancado toEntity(PostoAvancadoRequest request) {
        if (Objects.isNull(request)) return null;

        return PostoAvancado.builder()
                .nomePosto(request.nomePosto())
                .cidadePosto(request.cidadePosto())
                .totalItens(request.totalItens())
                .build();
    }

    @Override
    public PostoAvancadoResponse toResponse(PostoAvancado entity) {
        if (Objects.isNull(entity)) return null;

        return PostoAvancadoResponse.builder()
                .idPosto(entity.getIdPosto())
                .nomePosto(entity.getNomePosto())
                .cidadePosto(entity.getCidadePosto())
                .totalItens(entity.getTotalItens())
                .build();
    }

    @Override
    public List<PostoAvancado> findAll() {
        return repo.findAll();
    }

    @Override
    public List<PostoAvancado> findAll(Example<PostoAvancado> example) {
        return repo.findAll(example);
    }

    @Override
    public PostoAvancado findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public PostoAvancado save(PostoAvancado entity) {
        return repo.save(entity);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
