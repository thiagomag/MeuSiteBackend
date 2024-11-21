package br.com.thiagomagdalena.meusitebackend.usecase.video;

import br.com.thiagomagdalena.meusitebackend.usecase.UseCase;
import reactor.core.publisher.Mono;

public interface DeleteVideoUseCase extends UseCase<Long, Mono<Void>> {
}
