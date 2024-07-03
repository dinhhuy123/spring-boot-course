package huy.dev.identityService.mapper;

import huy.dev.identityService.dto.request.RoleRequest;
import huy.dev.identityService.dto.response.RoleResponse;
import huy.dev.identityService.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
