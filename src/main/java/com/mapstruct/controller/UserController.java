package com.mapstruct.controller;

import com.mapstruct.dto.AuthorAllDto;
import com.mapstruct.dto.UserGetDto;
import com.mapstruct.dto.UserPostDto;
import com.mapstruct.mapper.MapStructMapper;
import com.mapstruct.model.Author;
import com.mapstruct.repository.AuthorRepository;
import com.mapstruct.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final MapStructMapper mapStructMapper;
    private final UserRepository userRepository;
    private final AuthorRepository authorRepository;

    @PostMapping()
    public ResponseEntity<Void> create(@Valid @RequestBody UserPostDto userPostDto) {
        userRepository.save(mapStructMapper.userPostDtoToUser(userPostDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGetDto> getById(@PathVariable int id) {
        return new ResponseEntity<>(
                mapStructMapper.userToUserGetDto(
                    userRepository.findById(id).get()
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorAllDto> getAuthor(@PathVariable int id) {
        return new ResponseEntity<>(
                mapStructMapper.authorToAuthorAllDto(
                        authorRepository.findById(id).get()
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/authors")
    public ResponseEntity<List<AuthorAllDto>> getAuthor() {
        return new ResponseEntity<>(
                mapStructMapper.authorsToAuthorAllDto(
                        (List<Author>) authorRepository.findAll()
                ),
                HttpStatus.OK
        );
    }
}
