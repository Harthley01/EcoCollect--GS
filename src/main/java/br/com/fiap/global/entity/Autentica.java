package br.com.fiap.global.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_AUTENTICA")
public class Autentica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AUTENTICA")
    @SequenceGenerator(name = "SQ_AUTENTICA", sequenceName = "SQ_AUTENTICA", allocationSize = 1)
    @Column(name = "ID_AUTENTICA")
    private Long idAutentica;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "ST_LOGIN")
    private String statusLogin;
}
