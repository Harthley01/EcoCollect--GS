package br.com.fiap.global.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_PROFISSIONAL_POSTO")
public class ProfissionalPosto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROFISSIONAL_POSTO")
    @SequenceGenerator(name = "SQ_PROFISSIONAL_POSTO", sequenceName = "SQ_PROFISSIONAL_POSTO", allocationSize = 1)
    @Column(name = "ID_PROFISSIONAL")
    private Long idProfissional;

    @Column(name = "NM_PROFISSIONAL")
    private String nomeProfissional;

    @Column(name = "TP_PROFISSIONAL")
    private String tipoProfissional;

    @Column(name = "FL_SEXO")
    private String flSexo;

}
