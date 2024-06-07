package br.com.fiap.global.resource;

import br.com.fiap.global.dto.request.UsuarioRequest;
import br.com.fiap.global.dto.response.UsuarioResponse;
import br.com.fiap.global.entity.Usuario;
import br.com.fiap.global.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Usuários", description = "API para gerenciamento de usuários")
@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Retorna todos os usuários")
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> findAll(Pageable pageable) {
        Page<Usuario> usuariosPage = usuarioService.findAll(pageable);
        if (usuariosPage.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<UsuarioResponse> responses = usuariosPage.getContent().stream()
                .map(usuarioService::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @Operation(summary = "Retorna um usuário por ID")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findById(@Parameter(description = "ID do usuário") @PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        UsuarioResponse response = usuarioService.toResponse(usuario);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Cria um novo usuário")
    @PostMapping
    public ResponseEntity<UsuarioResponse> createUsuario(@RequestBody @Valid UsuarioRequest request) {
        Usuario usuario = usuarioService.toEntity(request);
        Usuario savedUsuario = usuarioService.save(usuario);
        UsuarioResponse response = usuarioService.toResponse(savedUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
