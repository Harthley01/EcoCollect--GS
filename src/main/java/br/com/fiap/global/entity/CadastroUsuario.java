package br.com.fiap.global.entity;

import lombok.*;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_CADASTRO_USUARIO")
public class CadastroUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CADASTRO_USUARIO")
    @SequenceGenerator(name = "SQ_CADASTRO_USUARIO", sequenceName = "SQ_CADASTRO_USUARIO", allocationSize = 1)
    @Column(name = "ID_CADASTRO_USUARIO")
    private Long idCadastroUsuario;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "SENHA")
    private String senha;
}
