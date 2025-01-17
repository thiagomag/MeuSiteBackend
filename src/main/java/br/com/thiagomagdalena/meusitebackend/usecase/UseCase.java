package br.com.thiagomagdalena.meusitebackend.usecase;


public interface UseCase<Input, Output> {

    Output execute(Input entry);

    default Output execute(Input entry, Object... args) {
        return execute(entry);
    }

}
