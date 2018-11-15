package br.com.cattany.study.service.impl;

import br.com.cattany.study.model.impl.Pessoa;
import br.com.cattany.study.model.impl.Treino;
import br.com.cattany.study.repository.PessoaRepository;
import br.com.cattany.study.service.PessoaService;
import br.com.cattany.study.service.exception.NotFoundOrphanRemovalOptionException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void delete(Pessoa pessoa) {
        repository.delete(pessoa);
    }

    @Override
    public void update(Pessoa pessoa) {
        repository.save(pessoa);
    }

    @Override
    public void deleteUsingOrphanRemoval(@NonNull Integer orphanRemovalOption, @NonNull Pessoa pessoa) {
        List<Treino> treinos = pessoa.getTreinos();
        final int treinoListSize = treinos.size();

        switch (orphanRemovalOption) {
            case 1:
                treinos.clear();
                break;

            case 2:
                for (int i = 0; i < treinoListSize; i++) {
                    treinos.set(i, null);
                }
                break;

            case 3:
                treinos.removeAll(treinos);
                break;

            case 4:
                for (int i = 0; i < treinoListSize; i++) {
                    treinos.remove(0);
                }
                break;

            default:
                throw new NotFoundOrphanRemovalOptionException(1, 4);
        }

        update(pessoa);
    }
}
