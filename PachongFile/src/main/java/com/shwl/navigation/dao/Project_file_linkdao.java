package com.shwl.navigation.dao;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shwl.navigation.model.Projectfilelink;

public interface Project_file_linkdao extends JpaRepository<Projectfilelink, Integer>{
	@Transactional
    @Modifying
    @Query(value = "truncate table Projectfilelink",nativeQuery = true)
    public void truncateTable();
}
