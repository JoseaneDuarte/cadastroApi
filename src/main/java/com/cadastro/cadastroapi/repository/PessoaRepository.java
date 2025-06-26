package com.cadastro.cadastroapi.repository;

import com.cadastro.cadastroapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
