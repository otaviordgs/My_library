package com.api.my_library.repositories;

import com.api.my_library.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livro, Long> {
}
