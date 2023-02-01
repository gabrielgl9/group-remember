package com.example.groupremember.services;

import com.example.groupremember.dtos.GroupDto;
import com.example.groupremember.models.Group;

import java.util.List;
import java.util.UUID;

public interface IGroupService {
    public Group save(GroupDto groupDto);

    public List<Group> findAll();

    public Group findOne(UUID id);

    public void delete(UUID id);

    public Group update(UUID id, GroupDto groupDto);
}
