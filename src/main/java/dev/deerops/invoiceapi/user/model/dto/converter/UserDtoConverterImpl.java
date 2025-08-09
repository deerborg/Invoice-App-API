package dev.deerops.invoiceapi.user.model.dto.converter;

import dev.deerops.invoiceapi.user.model.dto.request.CreateUserRequest;
import dev.deerops.invoiceapi.user.model.dto.response.UserResponse;
import dev.deerops.invoiceapi.user.model.entity.User;

import java.time.LocalDateTime;

public class UserDtoConverterImpl implements UserDtoConverter{

    @Override
    public User fromCreateUserToEntity(CreateUserRequest request) {

        if(request == null) return null;

        User userEntity = new User();

        userEntity.setUsername(request.getUsername());
        userEntity.setEmail(request.getEmail());
        userEntity.setPassword(request.getPassword());

        userEntity.setCreateAt(LocalDateTime.now());

        return userEntity;
    }

    @Override
    public UserResponse fromUserEntityToResponse(User entity) {

        if(entity == null) return null;

        UserResponse userResponse = new UserResponse();

        userResponse.setUserId(entity.getUserId());
        userResponse.setCreateAt(entity.getCreateAt());

        return userResponse;
    }
}
