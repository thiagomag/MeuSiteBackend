package br.com.thiagomagdalena.meusitebackend.usecase.links.impl;

import br.com.thiagomagdalena.meusitebackend.controller.links.dto.GetLinksUteis;
import br.com.thiagomagdalena.meusitebackend.controller.links.dto.LinksUteisResponse;
import br.com.thiagomagdalena.meusitebackend.repository.LinksUteisRepository;
import br.com.thiagomagdalena.meusitebackend.usecase.links.GetAllLinksUteisUseCase;
import br.com.thiagomagdalena.meusitebackend.usecase.links.adapter.LinksUteisResponseAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetAllLinksUteisUseCaseImpl implements GetAllLinksUteisUseCase {

    private final LinksUteisRepository linksUteisRepository;
    private final LinksUteisResponseAdapter linksUteisResponseAdapter;

    @Override
    public Flux<LinksUteisResponse> execute(GetLinksUteis getLinksUteis) {
        final var title = Optional.ofNullable(getLinksUteis.getTitle())
                .map(String::toLowerCase)
                .map(s -> "%" + s + "%")
                .orElse("");
        return linksUteisRepository.findLinksUteisBy(title)
                .map(linksUteisResponseAdapter::adapt);
    }
}
