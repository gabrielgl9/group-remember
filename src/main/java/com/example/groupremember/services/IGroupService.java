package com.example.groupremember.services;

import com.example.groupremember.dtos.GroupDto;
import com.example.groupremember.models.Group;

import java.util.List;

public interface IGroupService {
    public Group save(GroupDto groupDto);

    public List<Group> findAll();
}
