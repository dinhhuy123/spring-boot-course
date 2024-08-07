package huy.dev.identityservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import huy.dev.identityservice.dto.request.PermissionRequest;
import huy.dev.identityservice.dto.response.PermissionResponse;
import huy.dev.identityservice.entity.Permission;
import huy.dev.identityservice.mapper.PermissionMapper;
import huy.dev.identityservice.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PermissionService {
    PermissionRepository permissionRepository;

    PermissionMapper permissionMapper;

    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    public List<PermissionResponse> getAll() {
        var permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    public void delete(String permissionName) {
        permissionRepository.deleteById(permissionName);
    }
}
