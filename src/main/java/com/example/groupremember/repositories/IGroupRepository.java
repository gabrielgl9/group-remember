package com.example.groupremember.repositories;

import com.example.groupremember.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository()
public interface IGroupRepository extends JpaRepository<com.example.groupremember.models.Group, UUID> {
    boolean existsByName(String name);
}