package com.capgemini.JobApplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.JobApplication.entity.UserEntity;
import com.capgemini.JobApplication.entity.enums.UserRole;

@Repository

	public interface UserRepository extends JpaRepository<UserEntity, Long> {
	    Optional<UserEntity> findByEmail(String email);
	    
	    @Query("SELECT u FROM UserEntity u WHERE u.user_role = :role")
	    List<UserEntity> findByRole(@Param("role") UserRole role);
	
}
