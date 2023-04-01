package br.com.alura.AluraChallenge1.service;

import br.com.alura.AluraChallenge1.domain.Categoria;
import br.com.alura.AluraChallenge1.dto.CategoriaRequest;
import br.com.alura.AluraChallenge1.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Page<Categoria> list(final Pageable pageable) {
        return repository.findAll(pageable);
    }
    public Categoria get(Long id) {
        Optional<Categoria> optionalCategoria = repository.findById(id);
        if(optionalCategoria.isEmpty()){
            throw new IllegalStateException();
        }
        return optionalCategoria.get();
    }
    public Categoria save(CategoriaRequest request){
        Categoria categoria = new Categoria();
        categoria.setCor(request.getCor());
        categoria.setTitulo(request.getTitulo());
        return repository.save(categoria);
    }
    public Categoria update(CategoriaRequest request, Long id) {
        Categoria categoria = repository.getReferenceById(id);
        categoria.setCor(request.getCor());
        categoria.setTitulo(request.getTitulo());

        return repository.save(categoria);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
