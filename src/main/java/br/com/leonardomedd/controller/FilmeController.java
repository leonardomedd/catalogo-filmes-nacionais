package br.com.leonardomedd.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.leonardomedd.model.Filme;
import br.com.leonardomedd.repository.FilmeRepository;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    // Listar todos os filmes
    @GetMapping
    public List<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }

    // Buscar filme por ID
    @GetMapping("/{id}")
    public Filme buscarFilmePorId(@PathVariable Long id) {
        return filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }

    // Adicionar um filme
    @PostMapping
    public Filme adicionarFilme(@RequestBody Filme filme) {
        return filmeRepository.save(filme);
    }
    
    @PutMapping("/{id}")
    public Filme editarFilme(@PathVariable Long id, @RequestBody Filme filmeAtualizado) {
        Filme filmeExistente = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        filmeExistente.setTitulo(filmeAtualizado.getTitulo());
        filmeExistente.setDiretor(filmeAtualizado.getDiretor());
        filmeExistente.setAnoLancamento(filmeAtualizado.getAnoLancamento());
        filmeExistente.setGenero(filmeAtualizado.getGenero());
        return filmeRepository.save(filmeExistente);
    }
    
    @DeleteMapping("/{id}")
    public void removerFilme(@PathVariable Long id) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        filmeRepository.delete(filme);
    }
}