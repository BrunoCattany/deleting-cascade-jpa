package br.com.cattany.study.controller;

import br.com.cattany.study.enums.OrphanRemovalOption;
import br.com.cattany.study.model.impl.Pessoa;
import br.com.cattany.study.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Bruno Cattany
 * @since 29/10/2018
 */
@RepositoryRestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @DeleteMapping(path = "/{id}/deletarTreinos/orphanRemovalOptionNumber/{orphanRemovalOptionNumber}")
    public ResponseEntity<?> deletarTreinos(@PathVariable Integer id,
                                            @PathVariable Integer orphanRemovalOptionNumber) {
        final Pessoa pessoa = pessoaService.findById(id);
        try {
            OrphanRemovalOption option = OrphanRemovalOption.getFromOption(orphanRemovalOptionNumber);
            pessoaService.deleteTreinosUsingOrphanRemoval(option, pessoa);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.noContent().build();
    }

}
