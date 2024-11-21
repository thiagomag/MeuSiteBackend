package br.com.thiagomagdalena.meusitebackend.usecase.links;

import br.com.thiagomagdalena.meusitebackend.controller.links.dto.GetLinksUteis;
import br.com.thiagomagdalena.meusitebackend.controller.links.dto.LinksUteisResponse;
import br.com.thiagomagdalena.meusitebackend.usecase.UseCase;
import reactor.core.publisher.Flux;

public interface GetAllLinksUteisUseCase extends UseCase<GetLinksUteis, Flux<LinksUteisResponse>> {
}
