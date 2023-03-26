package br.com.alura.AluraChallenge1.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "video")
@Getter
@Setter
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private String url;

    @ManyToOne
    private Categoria categoria;
}
