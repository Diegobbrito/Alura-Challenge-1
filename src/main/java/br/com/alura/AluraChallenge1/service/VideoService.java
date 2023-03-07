package br.com.alura.AluraChallenge1.service;

import br.com.alura.AluraChallenge1.domain.Video;
import br.com.alura.AluraChallenge1.dto.VideoRequest;
import br.com.alura.AluraChallenge1.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    @Autowired
    private VideoRepository repository;
    public List<Video> getVideos() {
        return repository.findAll();
    }

    public Video getVideo(int id) {
        return repository.getVideoById(id);
    }

    public Video create(VideoRequest videoRequest) {
        Video video = new Video();
        video.setDescricao(videoRequest.getDescricao());
        video.setUrl(videoRequest.getUrl());
        video.setTitulo(videoRequest.getTitulo());
        return repository.save(video);
    }

    public Video update(VideoRequest videoRequest, Long id) {
        Video video = new Video();
        video.setDescricao(videoRequest.getDescricao());
        video.setUrl(videoRequest.getUrl());
        video.setTitulo(videoRequest.getTitulo());
        video.setId(id);

        return repository.save(video);

    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }


}
