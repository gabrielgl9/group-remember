package com.example.groupremember.services;

import com.example.groupremember.dtos.GroupDto;
import com.example.groupremember.models.Group;
import com.example.groupremember.repositories.IGroupRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class GroupService implements IGroupService {

    @Autowired
    IGroupRepository groupRepository;

    @Transactional
    public Group save(@Valid GroupDto groupDto) {
        if (groupRepository.existsByName(groupDto.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        var groupModel = new Group();
        BeanUtils.copyProperties(groupDto, groupModel);
        return groupRepository.save(groupModel);
    }

    public List<Group> findAll() {
        return this.groupRepository.findAll();
    }

}
