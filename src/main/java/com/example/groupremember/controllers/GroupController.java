package com.example.groupremember.controllers;

import com.example.groupremember.dtos.GroupDto;
import com.example.groupremember.models.Group;
import com.example.groupremember.services.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/group")
public class GroupController {
    @Autowired()
    IGroupService groupService;

    @PostMapping()
    public ResponseEntity<Object> saveGroup(@RequestBody GroupDto groupDto) {
        var groupCreated = groupService.save(groupDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(groupCreated);
    }

    @GetMapping()
    public ResponseEntity<List<Group>> getAllGroups() {
        var groups = groupService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(groups);
    }
}
