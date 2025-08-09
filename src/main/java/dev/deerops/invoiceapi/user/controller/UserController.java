package dev.deerops.invoiceapi.user.controller;

import dev.deerops.invoiceapi.common.util.result.ApiResponse;
import dev.deerops.invoiceapi.user.model.dto.request.CreateUserRequest;
import dev.deerops.invoiceapi.user.model.dto.response.UserResponse;
import dev.deerops.invoiceapi.user.model.util.UserControllerContains;
import dev.deerops.invoiceapi.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserControllerContains.USER_BASE_URL)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(UserControllerContains.PRIVATE+UserControllerContains.REGISTER)
    public ResponseEntity<ApiResponse<UserResponse>> createUserForRegister(@RequestBody CreateUserRequest createUserRequest){
        return userService.createUserForRegister(createUserRequest);
    }
}
