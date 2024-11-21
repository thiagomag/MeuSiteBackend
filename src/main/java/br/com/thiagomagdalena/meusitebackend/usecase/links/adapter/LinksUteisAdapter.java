package br.com.thiagomagdalena.meusitebackend.usecase.links.adapter;

import br.com.thiagomagdalena.meusitebackend.adapter.AbstractAdapter;
import br.com.thiagomagdalena.meusitebackend.controller.links.dto.LinksUteisRequest;
import br.com.thiagomagdalena.meusitebackend.model.LinksUteis;
import br.com.thiagomagdalena.meusitebackend.utils.JsonUtils;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LinksUteisAdapter extends AbstractAdapter<LinksUteisRequest, LinksUteis> {

    public LinksUteisAdapter(JsonUtils jsonUtils) {
        super(LinksUteis.class, jsonUtils);
    }

    @Override
    protected ModelMapper getModelMapper() {
        if (this.modelMapper == null) {
            this.modelMapper = super.getModelMapper();

            this.modelMapper.typeMap(LinksUteisRequest.class, LinksUteis.class)
                    .addMappings(mapping -> {
                        mapping.using(toDriveUrl()).map(LinksUteisRequest::getImageGoogleDriveId, LinksUteis::setImage);
                    });
        }
        return this.modelMapper;
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
