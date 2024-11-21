package br.com.thiagomagdalena.meusitebackend.usecase.links.impl;

import br.com.thiagomagdalena.meusitebackend.controller.links.dto.LinksUteisResponse;
import br.com.thiagomagdalena.meusitebackend.repository.LinksUteisRepository;
import br.com.thiagomagdalena.meusitebackend.usecase.links.GetLinksUteisById;
import br.com.thiagomagdalena.meusitebackend.usecase.links.adapter.LinksUteisResponseAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetLinksUteisByIdImpl implements GetLinksUteisById {
    private final LinksUteisRepository linksUteisRepository;
    private final LinksUteisResponseAdapter linksUteisResponseAdapter;

    @Override
    public Mono<LinksUteisResponse> execute(Long id) {
        return linksUteisRepository.findById(id)
                .map(linksUteisResponseAdapter::adapt);
    }
}
