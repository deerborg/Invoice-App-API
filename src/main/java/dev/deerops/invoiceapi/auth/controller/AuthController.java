package dev.deerops.invoiceapi.auth.controller;

import dev.deerops.invoiceapi.auth.model.dto.request.AuthRequest;
import dev.deerops.invoiceapi.auth.model.dto.response.AuthResponse;
import dev.deerops.invoiceapi.auth.service.AuthService;
import dev.deerops.invoiceapi.user.model.util.UserControllerContains;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UserControllerContains.AUTH_BASE_URL)
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @CrossOrigin
    @PostMapping(UserControllerContains.PUBLIC+UserControllerContains.LOGIN)
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest){
        return authService.authenticate(authRequest);
    }

}
