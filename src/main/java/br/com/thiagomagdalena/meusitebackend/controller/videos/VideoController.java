package br.com.thiagomagdalena.meusitebackend.controller.videos;

import br.com.thiagomagdalena.meusitebackend.controller.videos.dto.GetVideos;
import br.com.thiagomagdalena.meusitebackend.controller.videos.dto.VideoRequest;
import br.com.thiagomagdalena.meusitebackend.controller.videos.dto.VideoResponse;
import br.com.thiagomagdalena.meusitebackend.usecase.video.CreateVideoUseCase;
import br.com.thiagomagdalena.meusitebackend.usecase.video.DeleteVideoUseCase;
import br.com.thiagomagdalena.meusitebackend.usecase.video.GetAllVideosUseCase;
import br.com.thiagomagdalena.meusitebackend.usecase.video.GetVideoUseCase;
import br.com.thiagomagdalena.meusitebackend.usecase.video.UpdateVideoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/videos")
@RequiredArgsConstructor
public class VideoController {

    private final GetAllVideosUseCase getAllVideosUseCase;
    private final GetVideoUseCase getVideoUseCase;
    private final CreateVideoUseCase createVideoUseCase;
    private final UpdateVideoUseCase updateVideoUseCase;
    private final DeleteVideoUseCase deleteVideoUseCase;

    @GetMapping
    public Flux<VideoResponse> getAllVideos(@RequestParam(required = false) String title,
                                            @RequestParam(required = false) String url) {
        final var getVideos = GetVideos.builder()
                .title(title)
                .url(url)
                .build();
        return getAllVideosUseCase.execute(getVideos);
    }

    @GetMapping("/{slug}")
    public Mono<VideoResponse> getVideo(@PathVariable String slug) {
        return getVideoUseCase.execute(slug);
    }

    @PostMapping
    public Mono<VideoResponse> createVideo(@RequestBody VideoRequest videoRequest) {
        return createVideoUseCase.execute(videoRequest);
    }

    @PatchMapping("/{videoId}")
    public Mono<VideoResponse> updateVideo(@PathVariable Long videoId,
                                           @RequestBody VideoRequest videoRequest) {
        videoRequest.setId(videoId);
        return updateVideoUseCase.execute(videoRequest);
    }

    @DeleteMapping("/{videoId}")
    public Mono<Void> deleteVideo(@PathVariable Long videoId) {
        return deleteVideoUseCase.execute(videoId);
    }
}
