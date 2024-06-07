package br.com.fiap.global.resource;

import br.com.fiap.global.dto.request.CadastroUsuarioRequest;
import br.com.fiap.global.dto.response.CadastroUsuarioResponse;
import br.com.fiap.global.entity.CadastroUsuario;
import br.com.fiap.global.service.CadastroUsuarioService;
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

@Tag(name = "Cadastro de Usuário", description = "API para gerenciamento de cadastro de usuários")
@RestController
@RequestMapping("/cadastro")
public class CadastroUsuarioResource {

    @Autowired
    private CadastroUsuarioService usuarioService;

    @Operation(summary = "Retorna todos os usuários com paginação")
    @GetMapping
    public ResponseEntity<Page<CadastroUsuarioResponse>> findAll(Pageable pageable) {
        Page<CadastroUsuario> usuarios = usuarioService.findAll(pageable);
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Page<CadastroUsuarioResponse> responses = usuarios.map(usuarioService::toResponse);
        return ResponseEntity.ok(responses);
    }

    @Operation(summary = "Retorna um usuário por ID")
    @GetMapping("/{id}")
    public ResponseEntity<CadastroUsuarioResponse> findById(@Parameter(description = "ID do usuário") @PathVariable Long id) {
        CadastroUsuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        CadastroUsuarioResponse response = usuarioService.toResponse(usuario);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Cria um novo usuário")
    @PostMapping
    public ResponseEntity<CadastroUsuarioResponse> createUsuario(@RequestBody @Valid CadastroUsuarioRequest request) {
        CadastroUsuario usuario = usuarioService.toEntity(request);
        CadastroUsuario savedUsuario = usuarioService.save(usuario);
        CadastroUsuarioResponse response = usuarioService.toResponse(savedUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Atualiza um usuário existente")
    @PutMapping("/{id}")
    public ResponseEntity<CadastroUsuarioResponse> updateUsuario(@Parameter(description = "ID do usuário") @PathVariable Long id, @RequestBody @Valid CadastroUsuarioRequest request) {
        CadastroUsuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        usuario.setEmail(request.email());
        usuario.setLogin(request.login());
        usuario.setSenha(request.senha());
        CadastroUsuario updatedUsuario = usuarioService.save(usuario);
        CadastroUsuarioResponse response = usuarioService.toResponse(updatedUsuario);
        return ResponseEntity.ok(response);
    }
}
