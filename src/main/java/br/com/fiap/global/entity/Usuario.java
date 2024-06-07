package br.com.fiap.global.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    @SequenceGenerator(name = "SQ_USUARIO", sequenceName = "SQ_USUARIO", allocationSize = 1)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Column(name = "NR_CPF")
    private String nrCpf;

    @Column(name = "NR_RG")
    private String nrRg;

    @Column(name = "DT_NASCIMENTO")
    private Date dtNascimento;

    @Column(name = "FL_SEXO")
    private String flSexo;

    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = { CascadeType.MERGE, CascadeType.PERSIST }
    )
    @JoinColumn(
            name = "ID_PONTOS",
            foreignKey = @ForeignKey(name = "FK_USUARIO_PONTOS")
    )
    private Pontos pontos;
}
