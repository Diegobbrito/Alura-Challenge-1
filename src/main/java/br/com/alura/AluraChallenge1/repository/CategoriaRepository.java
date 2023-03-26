package br.com.alura.AluraChallenge1.repository;

import br.com.alura.AluraChallenge1.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long > {
}
