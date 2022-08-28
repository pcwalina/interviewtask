package com.example.demo.service;

import com.example.demo.dto.GithubUserInformationDTO;
import com.example.demo.mapper.RepositoryMapper;
import com.example.demo.model.ProfileRepositories;

import com.example.demo.model.RepositoryBranches;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GithubService {


    private final RestTemplate restTemplate;
    private final RepositoryMapper mapper;

    public List<GithubUserInformationDTO> getRepositories(String username) {

        List<ProfileRepositories> repositories = Arrays.stream(
                        Objects.requireNonNull(
                                restTemplate.getForObject(
                                        String.format("https://api.github.com/users/%s/repos", username),
                                        ProfileRepositories[].class
                                )
                        )
                )
                .filter(repo -> BooleanUtils.isNotTrue(repo.getFork()))
                .peek(this::getBranchesOfRepository)
                .collect(Collectors.toList());
        return mapper.toDtoList(repositories);


    }


    private void getBranchesOfRepository(ProfileRepositories repository) {
        Arrays.stream(Objects.requireNonNull(restTemplate.getForObject(

                        removeBranchSuffixFromUrl(repository.getBranchesUrl()),
                        RepositoryBranches[].class
                )))
                .forEach(branch -> repository.getBranchesList().add(branch));

    }

    //weird url from api response ending with {/branch} suffix
    private String removeBranchSuffixFromUrl(String url) {
        return url.replaceAll("\\{/branch}", "");
    }


}
