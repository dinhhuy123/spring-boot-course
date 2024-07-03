package huy.dev.identityService.mapper;

import huy.dev.identityService.dto.request.PermissionRequest;
import huy.dev.identityService.dto.response.PermissionResponse;
import huy.dev.identityService.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
