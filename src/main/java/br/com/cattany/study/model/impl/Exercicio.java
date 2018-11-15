package br.com.cattany.study.model.impl;

import br.com.cattany.study.model.definition.AbstractEntityWithIdIdentity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author Bruno Cattany
 * @since 28/10/2018
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Exercicio extends AbstractEntityWithIdIdentity {

    @Column(length = 30)
    private String nome;

    @ManyToMany(mappedBy = "exercicios")
    private List<Treino> treinos;
}
