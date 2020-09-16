package com.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.FileDB;
@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
	
	
	

}
