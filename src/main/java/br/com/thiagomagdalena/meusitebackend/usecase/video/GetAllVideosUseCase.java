package br.com.thiagomagdalena.meusitebackend.usecase.video;

import br.com.thiagomagdalena.meusitebackend.controller.videos.dto.GetVideos;
import br.com.thiagomagdalena.meusitebackend.controller.videos.dto.VideoResponse;
import br.com.thiagomagdalena.meusitebackend.usecase.UseCase;
import reactor.core.publisher.Flux;

public interface GetAllVideosUseCase extends UseCase<GetVideos, Flux<VideoResponse>> {
}
