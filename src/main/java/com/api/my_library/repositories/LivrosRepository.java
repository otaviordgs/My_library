package com.api.my_library.repositories;

import com.api.my_library.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LivrosRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByAutorContaining(String autor);

    @Query("select l from Livro l where l.paginas <= ?1 ")
    List<Livro> FindByNumberOfPages(int paginas);
}
