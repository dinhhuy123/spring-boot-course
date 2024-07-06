package huy.dev.identityservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import huy.dev.identityservice.dto.request.UserCreationRequest;
import huy.dev.identityservice.dto.request.UserUpdateRequest;
import huy.dev.identityservice.dto.response.UserResponse;
import huy.dev.identityservice.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
