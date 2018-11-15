package br.com.cattany.study.model.impl;

import br.com.cattany.study.model.definition.AbstractEntityWithIdIdentity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

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
class Frequencia extends AbstractEntityWithIdIdentity {

    @ManyToOne
    private Pessoa pessoa;

    private LocalDate dataRegistro;
}
