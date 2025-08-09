package dev.deerops.invoiceapi.user.service.impl;

import dev.deerops.invoiceapi.common.util.result.ApiResponse;
import dev.deerops.invoiceapi.common.util.result.ResponseHelper;
import dev.deerops.invoiceapi.user.model.dto.converter.UserConverter;
import dev.deerops.invoiceapi.user.model.dto.request.CreateUserRequest;
import dev.deerops.invoiceapi.user.model.dto.response.UserResponse;
import dev.deerops.invoiceapi.user.model.entity.Role;
import dev.deerops.invoiceapi.user.model.entity.User;
import dev.deerops.invoiceapi.user.model.util.exception.UserGeneralValidationsException;
import dev.deerops.invoiceapi.user.model.util.validation.UserValidation;
import dev.deerops.invoiceapi.user.repository.UserRepository;
import dev.deerops.invoiceapi.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final UserValidation userValidation;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter, UserValidation userValidation, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.userValidation = userValidation;
        this.encoder = encoder;
    }

    @Override
    public ResponseEntity<ApiResponse<UserResponse>> createUserForRegister(CreateUserRequest createUserRequest) {
        userValidation.validateUserField(
                createUserRequest.getUsername(), createUserRequest.getEmail(), createUserRequest.getPassword());

        if (userRepository.existsByUsernameOrEmail(createUserRequest.getUsername(), createUserRequest.getEmail())) {
            throw new UserGeneralValidationsException("Exist username or email");
        }

        User user = userConverter.fromCreateUserToEntity(createUserRequest);

        user.setPassword(encoder.encode(user.getPassword()));

        user.setCreateAt(LocalDateTime.now());

        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);

        user.setRole(Collections.singletonList(Role.USER));
        user.setEnabledAt(LocalDateTime.now());

        UserResponse response = userConverter
                .fromUserEntityToResponse(userRepository.save(user));

        return new ResponseEntity<>(ResponseHelper.CREATE(response), HttpStatus.CREATED);
    }
}
