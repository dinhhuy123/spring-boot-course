package huy.dev.identityService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import huy.dev.identityService.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {}
