package br.com.alura.AluraChallenge1.dto;

import br.com.alura.AluraChallenge1.domain.Video;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VideoResponse {

    List<Video> videos;

}
