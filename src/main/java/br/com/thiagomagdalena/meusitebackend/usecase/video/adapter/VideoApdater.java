package br.com.thiagomagdalena.meusitebackend.usecase.video.adapter;

import br.com.thiagomagdalena.meusitebackend.adapter.AbstractAdapter;
import br.com.thiagomagdalena.meusitebackend.controller.videos.dto.VideoRequest;
import br.com.thiagomagdalena.meusitebackend.model.Video;
import br.com.thiagomagdalena.meusitebackend.utils.JsonUtils;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VideoApdater extends AbstractAdapter<VideoRequest, Video> {

    public VideoApdater(JsonUtils jsonUtils) {
        super(Video.class, jsonUtils);
    }

    @Override
    protected ModelMapper getModelMapper() {
        if (this.modelMapper == null) {
            this.modelMapper = super.getModelMapper();

            this.modelMapper.typeMap(VideoRequest.class, Video.class)
                    .addMappings(mapping -> {
                        mapping.using(toUrl()).map(VideoRequest::getVideoId, Video::setUrl);
                        mapping.using(toDriveUrl()).map(VideoRequest::getImageGoogleDriveId, Video::setImage);
                    });
        }
        return this.modelMapper;
    }

    private Converter<String, String> toUrl() {
        return context -> {
            if (context.getSource() == null) {
                return null;
            }
            final var source = context.getSource();
            return Optional.ofNullable(source)
                    .map(s -> "/video/" + s)
                    .orElse(null);
        };
    }


    private Converter<String,String> toDriveUrl() {
        return context -> {
            if (context.getSource() == null) {
                return null;
            }
            final var source = context.getSource();
            return Optional.ofNullable(source)
                    .map(s -> "https://lh3.googleusercontent.com/d/" + s)
                    .orElse(null);
        };
    }

}
