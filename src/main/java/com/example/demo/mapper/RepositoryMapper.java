package com.example.demo.mapper;


import com.example.demo.dto.GithubUserInformationDTO;
import com.example.demo.model.ProfileRepositories;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RepositoryMapper {
    List<GithubUserInformationDTO> toDtoList(List<ProfileRepositories> profileRepositories);
}
