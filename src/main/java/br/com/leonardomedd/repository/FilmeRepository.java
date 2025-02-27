package br.com.leonardomedd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leonardomedd.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}