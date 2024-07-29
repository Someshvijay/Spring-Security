package com.somesh_spring_security.spring_secutity_client.repository;

import com.somesh_spring_security.spring_secutity_client.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenrepository extends JpaRepository<VerificationToken,Long> {
}
