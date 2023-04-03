package com.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project1.entities.AuthenticationInfo;

public interface AuthInfoRepository extends JpaRepository<AuthenticationInfo,Long>{

}
