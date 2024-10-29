package com.mapstruct.mapper;

import com.mapstruct.dto.AuthorAllDto;
import com.mapstruct.dto.AuthorDto;
import com.mapstruct.dto.BookDto;
import com.mapstruct.dto.BookSlimDto;
import com.mapstruct.dto.UserGetDto;
import com.mapstruct.dto.UserPostDto;
import com.mapstruct.model.Author;
import com.mapstruct.model.Book;
import com.mapstruct.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    BookSlimDto bookToBookSlimDto(Book book);

    BookDto bookToBookDto(Book book);

    AuthorDto authorToAuthorDto(Author author);

    AuthorAllDto authorToAuthorAllDto(Author author);

    List<AuthorAllDto> authorsToAuthorAllDto(List<Author> authors);

    UserGetDto userToUserGetDto(User user);

    User userPostDtoToUser(UserPostDto userPostDto);
}
