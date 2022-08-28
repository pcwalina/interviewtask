package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileRepositories {


    @JsonProperty("name")
    private String name;


    private String owner;

    @JsonProperty("fork")
    private Boolean fork;

    @JsonProperty("branches_url")
    private String branchesUrl;

    private List<RepositoryBranches> branchesList = new ArrayList<>();

    @JsonProperty("owner")
    private void unpackNameFromNestedObject(Map<String, String> owner) {
        this.owner = owner.get("login"); }
}
