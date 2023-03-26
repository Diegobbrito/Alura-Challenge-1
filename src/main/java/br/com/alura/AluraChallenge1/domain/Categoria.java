package br.com.alura.AluraChallenge1.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Table;

import java.util.List;

@Entity
@Table(appliesTo = "categoria")
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String cor;

    @OneToMany(mappedBy = "categoria")
    private List<Video> videos;
}
