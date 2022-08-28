package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryBranches {

    @JsonProperty("name")
    private String name;

    @JsonProperty("sha")
    private String sha;

    @JsonProperty("commit")
    private void unpackNestedCommitSha(Map<String, String> commit) {
        this.sha = commit.get("sha"); }

}
