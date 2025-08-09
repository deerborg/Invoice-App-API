package dev.deerops.invoiceapi.user.model.dto.converter;

import dev.deerops.invoiceapi.user.model.dto.request.CreateUserRequest;
import dev.deerops.invoiceapi.user.model.dto.response.UserResponse;
import dev.deerops.invoiceapi.user.model.entity.User;

public interface UserDtoConverter {
    User fromCreateUserToEntity(CreateUserRequest request);
    UserResponse fromUserEntityToResponse(User entity);
}
