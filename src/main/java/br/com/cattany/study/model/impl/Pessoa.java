package br.com.cattany.study.model.impl;

import br.com.cattany.study.model.definition.AbstractEntityWithIdIdentity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;

/**
 * @author Bruno Cattany
 * @since 28/10/2018
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa extends AbstractEntityWithIdIdentity {

    @Column(length = 60)
    private String nome;

    @Column(length = 11)
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = {PERSIST, REMOVE})
    private List<Treino> treinos;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa", cascade = REMOVE)
    private List<Frequencia> frequencias;

    @ManyToOne
    private Turma turma;

}
