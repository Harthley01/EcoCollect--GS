package br.com.fiap.global.resource;
import br.com.fiap.global.dto.request.AutenticaRequest;
import br.com.fiap.global.dto.response.AutenticaResponse;
import br.com.fiap.global.entity.Autentica;
import br.com.fiap.global.service.AutenticaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Tag(name = "Autentica", description = "API para gerenciamento de autenticação")
@RestController
@RequestMapping("/auth")
public class AutenticaResource {

    @Autowired
    private AutenticaService autenticaService;

    @Operation(summary = "Retorna todos os registros de autenticação com paginação")
    @GetMapping
    public ResponseEntity<Page<AutenticaResponse>> findAll(Pageable pageable) {
        Page<Autentica> autenticas = autenticaService.findAll(pageable);
        if (autenticas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Page<AutenticaResponse> responses = autenticas.map(autenticaService::toResponse);
        return ResponseEntity.ok(responses);
    }

    @Operation(summary = "Retorna um registro de autenticação por ID")
    @GetMapping("/{id}")
    public ResponseEntity<AutenticaResponse> findById(@PathVariable Long id) {
        Autentica autentica = autenticaService.findById(id);
        if (autentica == null) {
            return ResponseEntity.notFound().build();
        }
        AutenticaResponse response = autenticaService.toResponse(autentica);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Cria um novo registro de autenticação")
    @PostMapping
    public ResponseEntity<AutenticaResponse> createAutentica(@RequestBody @Valid AutenticaRequest request) {
        Autentica autentica = autenticaService.toEntity(request);
        Autentica savedAutentica = autenticaService.save(autentica);
        AutenticaResponse response = autenticaService.toResponse(savedAutentica);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Exclui um registro de autenticação por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutentica(@PathVariable Long id) {
        autenticaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
