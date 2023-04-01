package br.com.alura.AluraChallenge1.repository;

import br.com.alura.AluraChallenge1.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    Video getVideoById(int id);

    @Query(nativeQuery = true, value = "SELECT * FROM video LIMIT 5")
    List<Video> findLimitedTo();
}
