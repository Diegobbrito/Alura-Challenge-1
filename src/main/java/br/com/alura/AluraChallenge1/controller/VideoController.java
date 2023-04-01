package br.com.alura.AluraChallenge1.controller;

import br.com.alura.AluraChallenge1.domain.Video;
import br.com.alura.AluraChallenge1.dto.VideoRequest;
import br.com.alura.AluraChallenge1.dto.VideoResponse;
import br.com.alura.AluraChallenge1.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class VideoController {

    @Autowired
    private VideoService service;

    @GetMapping("videos/free")
    public ResponseEntity<VideoResponse> free(){
        return ResponseEntity.ok(service.getFreeVideos());
    }


    @GetMapping("videos")
    public ResponseEntity<Page<Video>> videos(Pageable pageable){
        return ResponseEntity.ok(service.getVideos(pageable));
    }

    @GetMapping("videos/{id}")
    public ResponseEntity<Video> video(@PathVariable int id){
        return ResponseEntity.ok(service.getVideo(id));
    }

    @PostMapping("videos")
    public ResponseEntity<Video> create(@RequestBody VideoRequest request){
        final var response = service.create(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("videos/{id}")
    public ResponseEntity<Video> update(@RequestBody VideoRequest request, @PathVariable Long id){
        return ResponseEntity.ok(service.update(request, id));
    }

    @DeleteMapping("videos/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }


}