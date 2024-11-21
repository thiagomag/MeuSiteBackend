package br.com.thiagomagdalena.meusitebackend.usecase.video;


import br.com.thiagomagdalena.meusitebackend.controller.videos.dto.VideoRequest;
import br.com.thiagomagdalena.meusitebackend.controller.videos.dto.VideoResponse;
import br.com.thiagomagdalena.meusitebackend.usecase.UseCase;
import reactor.core.publisher.Mono;

public interface CreateVideoUseCase extends UseCase<VideoRequest, Mono<VideoResponse>> {
}