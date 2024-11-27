package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.Credential;
import kr.ac.cau.project.tickets.entity.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Long> {
    Optional<Credential> findByUserinfo(Userinfo userinfo);
}