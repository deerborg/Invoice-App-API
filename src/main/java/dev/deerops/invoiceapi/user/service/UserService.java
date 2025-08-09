package dev.deerops.invoiceapi.user.service;

import dev.deerops.invoiceapi.common.util.result.ApiResponse;
import dev.deerops.invoiceapi.user.model.dto.request.CreateUserRequest;
import dev.deerops.invoiceapi.user.model.dto.response.UserResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<ApiResponse<UserResponse>> createUserForRegister(CreateUserRequest createUserRequest);
}
