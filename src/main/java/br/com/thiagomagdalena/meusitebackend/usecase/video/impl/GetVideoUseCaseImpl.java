package br.com.thiagomagdalena.meusitebackend.usecase.video.impl;

import br.com.thiagomagdalena.meusitebackend.controller.videos.dto.VideoResponse;
import br.com.thiagomagdalena.meusitebackend.controller.handler.exception.NotFoundException;
import br.com.thiagomagdalena.meusitebackend.repository.VideoRepository;
import br.com.thiagomagdalena.meusitebackend.usecase.video.GetVideoUseCase;
import br.com.thiagomagdalena.meusitebackend.usecase.video.adapter.VideoResponseAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetVideoUseCaseImpl implements GetVideoUseCase {

    private final VideoRepository videoRepository;
    private final VideoResponseAdapter videoResponseAdapter;

    @Override
    public Mono<VideoResponse> execute(String slug) {
        return videoRepository.findVideoBySlug(slug)
                .map(videoResponseAdapter::adapt)
                .switchIfEmpty(Mono.defer(() -> {
                    final var msg = String.format("Video with slug %s not found", slug);
                    return Mono.error(new NotFoundException(msg));
                }));
    }
}
