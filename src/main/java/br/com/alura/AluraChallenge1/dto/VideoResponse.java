package br.com.alura.AluraChallenge1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoResponse {

    private int id;
    private String titulo;
    private String descricao;
    private String url;

}
