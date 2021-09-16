package com.shwl.navigation.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shwl.navigation.model.Project;

public interface ProjectDao extends JpaRepository<Project, Integer>{
	@Transactional
    @Modifying
    @Query(value = "truncate table Project",nativeQuery = true)
    public void truncateTable();
}
