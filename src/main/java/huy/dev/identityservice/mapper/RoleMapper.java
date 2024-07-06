package huy.dev.identityservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import huy.dev.identityservice.dto.request.RoleRequest;
import huy.dev.identityservice.dto.response.RoleResponse;
import huy.dev.identityservice.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
