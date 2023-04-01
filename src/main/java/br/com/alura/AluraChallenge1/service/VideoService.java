package br.com.alura.AluraChallenge1.service;

import br.com.alura.AluraChallenge1.domain.Categoria;
import br.com.alura.AluraChallenge1.domain.Video;
import br.com.alura.AluraChallenge1.dto.VideoRequest;
import br.com.alura.AluraChallenge1.dto.VideoResponse;
import br.com.alura.AluraChallenge1.repository.CategoriaRepository;
import br.com.alura.AluraChallenge1.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    @Autowired
    private VideoRepository repository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    public Page<Video> getVideos(Pageable pageable) {
       return  repository.findAll(pageable);
    }

    public Video getVideo(int id) {
        return repository.getVideoById(id);
    }

    public Video create(VideoRequest videoRequest) {
        Categoria categoria = categoriaRepository.getReferenceById(videoRequest.getIdCategoria());
        Video video = new Video();
        video.setDescricao(videoRequest.getDescricao());
        video.setUrl(videoRequest.getUrl());
        video.setTitulo(videoRequest.getTitulo());
        video.setCategoria(categoria);
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


    public VideoResponse getFreeVideos() {
        final var data = repository.findLimitedTo();
        final var response = new VideoResponse();
        response.setVideos(data);
        return response;
    }
}
