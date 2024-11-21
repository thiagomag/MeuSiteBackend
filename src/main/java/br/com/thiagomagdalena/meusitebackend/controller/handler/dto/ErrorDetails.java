package br.com.thiagomagdalena.meusitebackend.controller.handler.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder(builderClassName = "ErrorDetailsBuilder", toBuilder = true)
@JsonDeserialize(builder = ErrorDetails.ErrorDetailsBuilder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ErrorDetails implements Serializable {

    @Builder.Default
    private final String code = null;

    @Builder.Default
    private final String origin = null;

    @Builder.Default
    private final String message = null;

    @Builder.Default
    private final List<Object> details = new ArrayList<>();

    @JsonPOJOBuilder(withPrefix = "")
    public static class ErrorDetailsBuilder {
    }
}
