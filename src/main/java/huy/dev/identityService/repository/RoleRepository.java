package huy.dev.identityService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import huy.dev.identityService.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {}
