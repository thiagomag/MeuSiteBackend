package br.com.thiagomagdalena.meusitebackend.usecase.links.adapter;

import br.com.thiagomagdalena.meusitebackend.adapter.AbstractAdapter;
import br.com.thiagomagdalena.meusitebackend.controller.links.dto.LinksUteisResponse;
import br.com.thiagomagdalena.meusitebackend.model.LinksUteis;
import br.com.thiagomagdalena.meusitebackend.utils.JsonUtils;
import org.springframework.stereotype.Component;

@Component
public class LinksUteisResponseAdapter extends AbstractAdapter<LinksUteis, LinksUteisResponse> {

    public LinksUteisResponseAdapter(JsonUtils jsonUtils) {
        super(LinksUteisResponse.class, jsonUtils);
    }
}
