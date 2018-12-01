package br.com.cattany.study.service.impl;

import br.com.cattany.study.enums.OrphanRemovalOption;
import br.com.cattany.study.model.impl.Pessoa;
import br.com.cattany.study.repository.PessoaRepository;
import br.com.cattany.study.service.PessoaService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;

/**
 * @author Bruno Cattany
 * @since 29/10/2018
 */
@Getter
@Service
public class PessoaServiceImpl implements PessoaService {

    @Getter
    @Setter
    private PessoaRepository repository;

    @Autowired
    public PessoaServiceImpl(PessoaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pessoa findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Pessoa pessoa) {
        repository.save(pessoa);
    }

    @Override
    public void deleteTreinosUsingOrphanRemoval(@Nonnull OrphanRemovalOption orphanRemovalOption, @Nonnull Pessoa pessoa) {
        orphanRemovalOption.getConsumer().accept(pessoa.getTreinos());
        update(pessoa);
    }
}
