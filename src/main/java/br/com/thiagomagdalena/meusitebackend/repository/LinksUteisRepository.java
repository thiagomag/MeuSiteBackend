package br.com.thiagomagdalena.meusitebackend.repository;

import br.com.thiagomagdalena.meusitebackend.model.LinksUteis;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface LinksUteisRepository extends ReactiveCrudRepository<LinksUteis, Long> {

    @Query("SELECT lu.* FROM public.links_uteis lu " +
            "WHERE (:title = '' OR LOWER(lu.title) = :title)")
    Flux<LinksUteis> findLinksUteisBy(@Param("title") String title);
}
