package br.com.fiap.global.service;

import br.com.fiap.global.dto.request.UsuarioRequest;
import br.com.fiap.global.dto.response.UsuarioResponse;
import br.com.fiap.global.entity.Usuario;
import br.com.fiap.global.repository.UsuarioRepository;
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
public class UsuarioService implements ServiceDTO<Usuario, UsuarioRequest, UsuarioResponse> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario toEntity(UsuarioRequest request) {
        if (Objects.isNull(request)) return null;

        return Usuario.builder()
                .nrCpf(request.nrCpf())
                .nrRg(request.nrRg())
                .dtNascimento(request.dtNascimento())
                .flSexo(request.flSexo())
                .build();
    }

    @Override
    public UsuarioResponse toResponse(Usuario entity) {
        if (Objects.isNull(entity)) return null;

        return UsuarioResponse.builder()
                .idUsuario(entity.getIdUsuario())
                .nrCpf(entity.getNrCpf())
                .nrRg(entity.getNrRg())
                .dtNascimento(entity.getDtNascimento())
                .flSexo(entity.getFlSexo())
                .build();
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> findAll(Example<Usuario> example) {
        return usuarioRepository.findAll(example);
    }

    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    public Page<Usuario> findAll(Example<Usuario> example, Pageable pageable) {
        return usuarioRepository.findAll(example, pageable);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario entity) {
        return usuarioRepository.save(entity);
    }
}
