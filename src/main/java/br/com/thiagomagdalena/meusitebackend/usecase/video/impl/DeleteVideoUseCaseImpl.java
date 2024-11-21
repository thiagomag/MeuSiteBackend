package br.com.thiagomagdalena.meusitebackend.usecase.video.impl;

import br.com.thiagomagdalena.meusitebackend.controller.handler.exception.NotFoundException;
import br.com.thiagomagdalena.meusitebackend.repository.VideoRepository;
import br.com.thiagomagdalena.meusitebackend.usecase.video.DeleteVideoUseCase;
import br.com.thiagomagdalena.meusitebackend.usecase.video.adapter.VideoResponseAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteVideoUseCaseImpl implements DeleteVideoUseCase {

    private final VideoRepository videoRepository;
    private final VideoResponseAdapter videoResponseAdapter;

    @Override
    public Mono<Void> execute(Long videoId) {
        return videoRepository.findById(videoId)
                .map(videoResponseAdapter::adapt)
                .switchIfEmpty(Mono.defer(() -> {
                    final var msg = String.format("Video with id %s not found", videoId);
                    return Mono.error(new NotFoundException(msg));
                }))
                .then();
    }
}
