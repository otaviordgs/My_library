package com.api.my_library.services;

import com.api.my_library.models.Livro;
import com.api.my_library.repositories.LivrosRepository;
import com.sun.jdi.request.ExceptionRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private LivrosRepository livrosRepository;

    //Injeção de dependencia via construtor
    public LivroService(LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
    }

    public Livro save(Livro livro) {
        return livrosRepository.save(livro);
    }

    public List<Livro> getAllLivros() {
        return livrosRepository.findAll();
    }

    public void removeLivro(Long id) {
        livrosRepository.deleteById(id);
    }

    public Optional<Livro> findById(Long id) {
        return livrosRepository.findById(id);
    }
}
