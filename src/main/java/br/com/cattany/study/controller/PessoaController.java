package br.com.cattany.study.controller;

import br.com.cattany.study.model.impl.Pessoa;
import br.com.cattany.study.service.PessoaService;
import br.com.cattany.study.service.exception.NotFoundOrphanRemovalOptionException;
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
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @DeleteMapping(path = "/pessoas/{id}")
    public ResponseEntity<?> removeChildrenReference(@PathVariable Integer id,
                                                     @RequestParam(required = false) Integer orphanRemovalOption) {
        final Pessoa pessoa = pessoaService.findById(id);
        try {
            if (orphanRemovalOption != null) {
                pessoaService.deleteUsingOrphanRemoval(orphanRemovalOption, pessoa);
            } else {
                pessoaService.delete(pessoa);
            }
        } catch (NotFoundOrphanRemovalOptionException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.noContent().build();
    }

}
