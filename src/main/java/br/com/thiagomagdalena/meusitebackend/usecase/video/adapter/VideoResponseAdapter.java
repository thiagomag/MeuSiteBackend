package br.com.thiagomagdalena.meusitebackend.usecase.video.adapter;

import br.com.thiagomagdalena.meusitebackend.adapter.AbstractAdapter;
import br.com.thiagomagdalena.meusitebackend.controller.videos.dto.VideoResponse;
import br.com.thiagomagdalena.meusitebackend.model.Video;
import br.com.thiagomagdalena.meusitebackend.utils.JsonUtils;
import org.springframework.stereotype.Component;

@Component
public class VideoResponseAdapter extends AbstractAdapter<Video, VideoResponse> {

    public VideoResponseAdapter(JsonUtils jsonUtils) {
        super(VideoResponse.class, jsonUtils);
    }
}
