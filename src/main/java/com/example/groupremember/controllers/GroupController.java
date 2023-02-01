package com.example.groupremember.controllers;

import com.example.groupremember.dtos.GroupDto;
import com.example.groupremember.models.Group;
import com.example.groupremember.services.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<Group> getOneGroup(@PathVariable(value = "id") UUID id) {
        var group = this.groupService.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(group);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGroup(@PathVariable(value = "id") UUID id) {
        this.groupService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateGroup(@PathVariable(value = "id") UUID id,
                                              @RequestBody GroupDto groupDto) {

        var groupCreated = groupService.update(id, groupDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(groupCreated);
    }


}
