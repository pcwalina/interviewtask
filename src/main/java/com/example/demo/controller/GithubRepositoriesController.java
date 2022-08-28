package com.example.demo.controller;


import com.example.demo.service.GithubService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class GithubRepositoriesController {

    private final GithubService githubService;

    @GetMapping(value = "/repositories/{username}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRepositories(@PathVariable String username) {
        return new ResponseEntity<>(githubService.getRepositories(username), HttpStatus.OK);
    }

}
