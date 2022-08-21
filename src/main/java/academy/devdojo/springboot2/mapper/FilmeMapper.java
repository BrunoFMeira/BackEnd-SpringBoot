package academy.devdojo.springboot2.mapper;

import academy.devdojo.springboot2.domain.Filme;
import academy.devdojo.springboot2.requests.filme.FilmePostRequestBody;
import academy.devdojo.springboot2.requests.filme.FilmePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class FilmeMapper {
    public static final FilmeMapper INSTANCE = Mappers.getMapper(FilmeMapper.class);

    public abstract Filme toFilme(FilmePostRequestBody filmePostRequestBody);

    public abstract Filme toFilme(FilmePutRequestBody filmePostRequestBody);
}