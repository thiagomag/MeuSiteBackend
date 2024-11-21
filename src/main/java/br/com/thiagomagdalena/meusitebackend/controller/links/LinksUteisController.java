package br.com.thiagomagdalena.meusitebackend.controller.links;

import br.com.thiagomagdalena.meusitebackend.controller.links.dto.GetLinksUteis;
import br.com.thiagomagdalena.meusitebackend.controller.links.dto.LinksUteisRequest;
import br.com.thiagomagdalena.meusitebackend.controller.links.dto.LinksUteisResponse;
import br.com.thiagomagdalena.meusitebackend.usecase.links.CreateLinksUteisUseCase;
import br.com.thiagomagdalena.meusitebackend.usecase.links.GetAllLinksUteisUseCase;
import br.com.thiagomagdalena.meusitebackend.usecase.links.GetLinksUteisById;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/links")
public class LinksUteisController {

    private final GetAllLinksUteisUseCase getAllLinksUteisUseCase;
    private final GetLinksUteisById getLinksUteisById;
    private final CreateLinksUteisUseCase createLinksUteisUseCase;

    @GetMapping
    public Flux<LinksUteisResponse> getAllLinksUteis(@RequestParam String title) {
        final var getLinks = GetLinksUteis.builder()
                .title(title)
                .build();
        return getAllLinksUteisUseCase.execute(getLinks);
    }

    @GetMapping("/{id}")
    public Mono<LinksUteisResponse> getLinksUteisById(@RequestParam Long id) {
        return getLinksUteisById.execute(id);
    }

    @PostMapping
    public Mono<LinksUteisResponse> createLinkUtil(@RequestBody LinksUteisRequest linksUteisRequest) {
        return createLinksUteisUseCase.execute(linksUteisRequest);
    }
}
