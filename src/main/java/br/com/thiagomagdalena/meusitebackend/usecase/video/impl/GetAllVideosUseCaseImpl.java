package br.com.thiagomagdalena.meusitebackend.usecase.video.impl;

import br.com.thiagomagdalena.meusitebackend.controller.videos.dto.GetVideos;
import br.com.thiagomagdalena.meusitebackend.controller.videos.dto.VideoResponse;
import br.com.thiagomagdalena.meusitebackend.model.Video;
import br.com.thiagomagdalena.meusitebackend.repository.VideoRepository;
import br.com.thiagomagdalena.meusitebackend.usecase.video.GetAllVideosUseCase;
import br.com.thiagomagdalena.meusitebackend.usecase.video.adapter.VideoResponseAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetAllVideosUseCaseImpl implements GetAllVideosUseCase {

    private final VideoRepository videoRepository;
    private final VideoResponseAdapter videoResponseAdapter;

    @Override
    public Flux<VideoResponse> execute(GetVideos getVideos) {
        return findVideosByParams(getVideos)
                .map(videoResponseAdapter::adapt)
                .sort(Comparator.comparing(VideoResponse::getId));
    }

    private Flux<Video> findVideosByParams(GetVideos getVideos) {
        final var title = Optional.ofNullable(getVideos.getTitle())
                .map(String::toLowerCase)
                .map(s -> "%" + s + "%")
                .orElse("");
        final var url = Optional.ofNullable(getVideos.getUrl())
                .map(String::toLowerCase)
                .map(s -> "%" + s + "%")
                .orElse("");
        return videoRepository.findVideosBy(title, url);
    }
}
