package br.com.alura.AluraChallenge1.controller;

import br.com.alura.AluraChallenge1.domain.Categoria;
import br.com.alura.AluraChallenge1.dto.CategoriaRequest;
import br.com.alura.AluraChallenge1.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> categoria(){
       return ResponseEntity.ok( service.list());
    }

    @GetMapping("categorias/{id}")
    public ResponseEntity<Categoria> video(@PathVariable Long id){

        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping("/categorias")
    public ResponseEntity<Categoria> criar(@RequestBody CategoriaRequest request){
       return ResponseEntity.ok(service.save(request));
    }



    @PutMapping("categorias/{id}")
    public ResponseEntity<Categoria> update(@RequestBody CategoriaRequest request, @PathVariable Long id){
        return ResponseEntity.ok(service.update(request, id));
    }

    @DeleteMapping("categorias/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
