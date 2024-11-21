package br.com.thiagomagdalena.meusitebackend.repository;

import br.com.thiagomagdalena.meusitebackend.model.Video;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VideoRepository extends ReactiveCrudRepository<Video, Long> {

    @Query("SELECT v.* FROM public.video v " +
            "WHERE (:title = '' OR LOWER(v.title) LIKE :title) " +
            "AND (:url = '' OR LOWER(v.url) LIKE :url)")
    Flux<Video> findVideosBy(@Param("title") String title,
                             @Param("url") String url);

    Mono<Video> findVideoBySlug(String slug);
}
