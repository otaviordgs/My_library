package com.api.my_library.controllers;

import com.api.my_library.dtos.LivroDto;
import com.api.my_library.models.Livro;
import com.api.my_library.services.LivroService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/livros")
public class LivroController {
    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> getAllLivros(){
        return livroService.getAllLivros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getLivroById(@PathVariable Long id){
        Optional<Livro> livroOptional = livroService.findById(id);
        if(livroOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id não foi encontrado!");
        return ResponseEntity.status(HttpStatus.OK).body(livroOptional.get());
    }

    @PostMapping
    public ResponseEntity<Livro> saveLivro(@RequestBody @Valid LivroDto livroDto){
        var livro = new Livro();
        BeanUtils.copyProperties(livroDto, livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.save(livro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLivro(@PathVariable Long id,@RequestBody
                                                @Valid LivroDto livroDto){
        Optional<Livro> livroOptional = livroService.findById(id);
        if(livroOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id passado não foi encontrado");

        var livro = new Livro();
        BeanUtils.copyProperties(livroDto, livro);
        livro.setId(livroOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(livroService.save(livro));
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> removeLivro(@PathVariable Long id){
        Optional<Livro> livroOptional = livroService.findById(id);
        if(livroOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id passado não foi encontrado");
        livroService.removeLivro(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Livro removido com sucesso!");
    }
}
