package huy.dev.identityService.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import huy.dev.identityService.dto.request.UserCreationRequest;
import huy.dev.identityService.dto.request.UserUpdateRequest;
import huy.dev.identityService.dto.response.UserResponse;
import huy.dev.identityService.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
