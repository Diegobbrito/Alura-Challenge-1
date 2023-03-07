package br.com.alura.AluraChallenge1.repository;

import br.com.alura.AluraChallenge1.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    Video getVideoById(int id);

}
