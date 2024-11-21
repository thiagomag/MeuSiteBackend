package br.com.thiagomagdalena.meusitebackend.usecase.links.impl;

import br.com.thiagomagdalena.meusitebackend.controller.links.dto.LinksUteisRequest;
import br.com.thiagomagdalena.meusitebackend.controller.links.dto.LinksUteisResponse;
import br.com.thiagomagdalena.meusitebackend.repository.LinksUteisRepository;
import br.com.thiagomagdalena.meusitebackend.usecase.links.CreateLinksUteisUseCase;
import br.com.thiagomagdalena.meusitebackend.usecase.links.adapter.LinksUteisAdapter;
import br.com.thiagomagdalena.meusitebackend.usecase.links.adapter.LinksUteisResponseAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateLinksUteisUseCaseImpl implements CreateLinksUteisUseCase {

    private final LinksUteisRepository linksUteisRepository;
    private final LinksUteisAdapter linksUteisAdapter;
    private final LinksUteisResponseAdapter linksUteisResponseAdapter;

    @Override
    public Mono<LinksUteisResponse> execute(LinksUteisRequest linksUteisRequest) {
        final var linksUteis = linksUteisAdapter.adapt(linksUteisRequest);
        return linksUteisRepository.save(linksUteis)
                .map(linksUteisResponseAdapter::adapt);
    }
}
