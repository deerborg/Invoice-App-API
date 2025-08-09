package dev.deerops.invoiceapi.auth.service.impl;

import dev.deerops.invoiceapi.auth.model.dto.request.AuthRequest;
import dev.deerops.invoiceapi.auth.model.dto.response.AuthResponse;
import dev.deerops.invoiceapi.auth.service.AuthService;
import dev.deerops.invoiceapi.common.config.jwt.JwtService;
import dev.deerops.invoiceapi.user.model.entity.User;
import dev.deerops.invoiceapi.user.model.util.exception.UserGeneralValidationsException;
import dev.deerops.invoiceapi.user.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationProvider authenticationProvider;

    public AuthServiceImpl(UserRepository userRepository, JwtService jwtService, AuthenticationProvider authenticationProvider) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {

        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());

            authenticationProvider.authenticate(authenticationToken);


            User user = userRepository.findByUsername(authRequest.getUsername()).orElseThrow();

            String token = jwtService.generateToken(user);

            return new AuthResponse(token);
        } catch (Exception e) {
            throw new UserGeneralValidationsException(e.getMessage());
        }
    }
}
