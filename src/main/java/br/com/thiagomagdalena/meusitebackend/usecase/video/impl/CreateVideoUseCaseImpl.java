package br.com.thiagomagdalena.meusitebackend.usecase.video.impl;

import br.com.thiagomagdalena.meusitebackend.controller.videos.dto.VideoRequest;
import br.com.thiagomagdalena.meusitebackend.controller.videos.dto.VideoResponse;
import br.com.thiagomagdalena.meusitebackend.repository.VideoRepository;
import br.com.thiagomagdalena.meusitebackend.usecase.video.CreateVideoUseCase;
import br.com.thiagomagdalena.meusitebackend.usecase.video.adapter.VideoApdater;
import br.com.thiagomagdalena.meusitebackend.usecase.video.adapter.VideoResponseAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateVideoUseCaseImpl implements CreateVideoUseCase {

    private final VideoRepository videoRepository;
    private final VideoApdater videoApdater;
    private final VideoResponseAdapter videoResponseAdapter;

    @Override
    public Mono<VideoResponse> execute(VideoRequest request) {
        final var video = videoApdater.adapt(request);
        return videoRepository.save(video)
                .map(videoResponseAdapter::adapt)
                .switchIfEmpty(Mono.error(new RuntimeException("Error creating video")));
    }
}
