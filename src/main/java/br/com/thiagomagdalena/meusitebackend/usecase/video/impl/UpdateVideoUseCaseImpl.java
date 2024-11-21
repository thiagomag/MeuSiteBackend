package br.com.thiagomagdalena.meusitebackend.usecase.video.impl;

import br.com.thiagomagdalena.meusitebackend.controller.videos.dto.VideoRequest;
import br.com.thiagomagdalena.meusitebackend.controller.videos.dto.VideoResponse;
import br.com.thiagomagdalena.meusitebackend.controller.handler.exception.NotFoundException;
import br.com.thiagomagdalena.meusitebackend.repository.VideoRepository;
import br.com.thiagomagdalena.meusitebackend.usecase.video.UpdateVideoUseCase;
import br.com.thiagomagdalena.meusitebackend.usecase.video.adapter.VideoApdater;
import br.com.thiagomagdalena.meusitebackend.usecase.video.adapter.VideoResponseAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UpdateVideoUseCaseImpl implements UpdateVideoUseCase {

    private final VideoRepository videoRepository;
    private final VideoApdater videoAdapter;
    private final VideoResponseAdapter videoResponseAdapter;

    @Override
    public Mono<VideoResponse> execute(VideoRequest videoRequest) {
        return videoRepository.findById(videoRequest.getId())
                .map(video -> videoAdapter.adapt(videoRequest, video))
                .flatMap(videoRepository::save)
                .map(videoResponseAdapter::adapt)
                .switchIfEmpty(Mono.defer(() -> {
                    final var msg = String.format("Video with id %s not found", videoRequest.getId());
                    return Mono.error(new NotFoundException(msg));
                }));
    }
}
