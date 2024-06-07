package br.com.fiap.global.service;

import br.com.fiap.global.dto.request.PontosRequest;
import br.com.fiap.global.dto.response.PontosResponse;
import br.com.fiap.global.entity.Pontos;
import br.com.fiap.global.repository.PontosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class PontosService implements ServiceDTO<Pontos, PontosRequest, PontosResponse> {

    @Autowired
    private PontosRepository repo;

    @Override
    public Pontos toEntity(PontosRequest r) {
        if (Objects.isNull(r)) return null;

        return Pontos.builder()
                .qtPontos(r.qtPontos())
                .atributo2(r.atributo2())
                .build();
    }

    @Override
    public PontosResponse toResponse(Pontos e) {
        if (Objects.isNull(e)) return null;

        return PontosResponse.builder()
                .idPontos(e.getIdPontos())
                .qtPontos(e.getQtPontos())
                .atributo2(e.getAtributo2())
                .build();
    }

    @Override
    public List<Pontos> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Pontos> findAll(Example<Pontos> example) {
        return repo.findAll(example);
    }

    public Page<Pontos> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Page<Pontos> findAll(Example<Pontos> example, Pageable pageable) {
        return repo.findAll(example, pageable);
    }

    @Override
    public Pontos findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Pontos save(Pontos e) {
        return repo.save(e);
    }
}
