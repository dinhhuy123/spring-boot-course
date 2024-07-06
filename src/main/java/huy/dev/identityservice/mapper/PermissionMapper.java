package huy.dev.identityservice.mapper;

import org.mapstruct.Mapper;

import huy.dev.identityservice.dto.request.PermissionRequest;
import huy.dev.identityservice.dto.response.PermissionResponse;
import huy.dev.identityservice.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
