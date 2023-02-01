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
import java.util.Optional;
import java.util.UUID;

@Service
public class GroupService implements IGroupService {

    @Autowired
    IGroupRepository groupRepository;

    @Transactional
    public Group save(@Valid GroupDto groupDto) {
        if (this.groupRepository.existsByName(groupDto.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        var groupModel = new Group();
        BeanUtils.copyProperties(groupDto, groupModel);
        return this.groupRepository.save(groupModel);
    }

    public List<Group> findAll() {
        return this.groupRepository.findAll();
    }

    public Group findOne(UUID id) {
        Optional<Group> groupOptional = this.groupRepository.findById(id);

        if (!groupOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return groupOptional.get();
    }

    @Transactional()
    public void delete(UUID id) {
        Optional<Group> groupOptional = this.groupRepository.findById(id);

        if (!groupOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        this.groupRepository.delete(groupOptional.get());
    }

    @Transactional()
    public Group update(UUID id, @Valid GroupDto groupDto) {
        if (this.groupRepository.existsByName(groupDto.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        Optional<Group> groupOptional = this.groupRepository.findById(id);
        if (!groupOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        var groupModel = new Group();
        BeanUtils.copyProperties(groupDto, groupModel);
        groupModel.setId(id);

        return this.groupRepository.save(groupModel);
    }
}
