package com.abdalrhman.liquibase_article.rest.controller;

import com.abdalrhman.liquibase_article.model.User;
import com.abdalrhman.liquibase_article.rest.path.UserPathApi;
import com.abdalrhman.liquibase_article.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(UserPathApi.USER_PATH)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {

        return ResponseEntity
                .ok(userService.getAllUser());
    }

    @PostMapping
    public ResponseEntity<User> createUser(
            @RequestBody final User user
    ) throws URISyntaxException {

        return ResponseEntity
                .created(new URI(UserPathApi.USER_PATH))
                .body(userService.createUser(user));
    }

    @GetMapping(UserPathApi.USER_ID_PATH)
    public ResponseEntity<User> getUserById(
            @PathVariable("id") Long id
    ) throws Exception {

        return ResponseEntity
                .ok(userService.getUserById(id));
    }

    @PutMapping()
    public ResponseEntity<User> updateUser(
            @RequestBody final User user
    ) throws Exception {

        return ResponseEntity
                .created(new URI(UserPathApi.USER_PATH))
                .body(userService.updateUser(user));
    }

    @DeleteMapping(UserPathApi.USER_ID_PATH)
    public ResponseEntity<Void> deleteUser(
            @PathVariable final Long id
    ) throws Exception {

        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
