package br.com.cattany.study.model.impl;

import br.com.cattany.study.model.definition.AbstractEntityWithIdIdentity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

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
class Academia extends AbstractEntityWithIdIdentity {

    @Column(length = 30)
    private String nome;

    @Column(length = 50)
    private String endereco;
}
