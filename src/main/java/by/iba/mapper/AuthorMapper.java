package by.iba.mapper;

import by.iba.domain.AuthorEntity;
import by.iba.dto.AuthorDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorMapper {

    public AuthorDto convertToDto(AuthorEntity author) {

        AuthorDto authorDto = new AuthorDto(author.getId(), author.getFirstName(), author.getLastName(),
                author.getDateOfBirth(), author.getCountry());
        return authorDto;
    }

    public AuthorEntity convertToEntity(AuthorDto authorDto){

        AuthorEntity authorEntity = new AuthorEntity(authorDto.getId(), authorDto.getFirstName(), authorDto.getLastName(),
                authorDto.getDateOfBirth(), authorDto.getCountry());
        return authorEntity;
    }

    public List<AuthorDto> convertToList(List<AuthorEntity> authors){
        return authors.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    public List<AuthorEntity> convertToListEntity(List<AuthorDto> authors){
        return authors.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }
}
