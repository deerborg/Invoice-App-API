package dev.deerops.invoiceapi.auth.service;

import dev.deerops.invoiceapi.auth.model.dto.request.AuthRequest;
import dev.deerops.invoiceapi.auth.model.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse authenticate(AuthRequest authRequest);
}
