package br.com.thiagomagdalena.meusitebackend.usecase.links;

import br.com.thiagomagdalena.meusitebackend.controller.links.dto.LinksUteisRequest;
import br.com.thiagomagdalena.meusitebackend.controller.links.dto.LinksUteisResponse;
import br.com.thiagomagdalena.meusitebackend.usecase.UseCase;
import reactor.core.publisher.Mono;

public interface CreateLinksUteisUseCase extends UseCase<LinksUteisRequest, Mono<LinksUteisResponse>> {
}
