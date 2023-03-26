package br.com.alura.AluraChallenge1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class VideoRequest {
    private String titulo;
    private String descricao;
    private String url;
    private Long idCategoria;
}
