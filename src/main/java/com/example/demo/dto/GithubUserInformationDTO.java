package com.example.demo.dto;


import com.example.demo.model.ProfileRepositories;
import com.example.demo.model.RepositoryBranches;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GithubUserInformationDTO {
    private String owner;
    private String name;
    private List<RepositoryBranches> branchesList;


}
