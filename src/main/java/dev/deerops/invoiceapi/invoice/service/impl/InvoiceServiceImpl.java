package dev.deerops.invoiceapi.invoice.service.impl;

import dev.deerops.invoiceapi.common.util.result.ApiResponse;
import dev.deerops.invoiceapi.common.util.result.ResponseHelper;
import dev.deerops.invoiceapi.invoice.model.dto.converter.InvoiceConverter;
import dev.deerops.invoiceapi.invoice.model.dto.request.CreateInvoiceRequest;
import dev.deerops.invoiceapi.invoice.model.dto.response.InvoiceDetailsResponse;
import dev.deerops.invoiceapi.invoice.model.entity.Invoice;
import dev.deerops.invoiceapi.invoice.repository.InvoiceRepository;
import dev.deerops.invoiceapi.invoice.service.InvoiceService;
import dev.deerops.invoiceapi.user.model.entity.User;
import dev.deerops.invoiceapi.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceConverter converter;
    private final UserRepository userRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceConverter converter, UserRepository userRepository) {
        this.invoiceRepository = invoiceRepository;
        this.converter = converter;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<ApiResponse<InvoiceDetailsResponse>> createInvoice(CreateInvoiceRequest request) {
        User user = userRepository.findByUserId(request.getUserId());
        if (user == null) {
            return new ResponseEntity<>(ResponseHelper.ERROR("Not found user"), HttpStatus.NOT_FOUND);
        }

        Invoice invoice = converter.fromCreateInvoiceRequest(request);
        invoice.setUser(user);

        InvoiceDetailsResponse response =
                converter.fromInvoiceEntityToDetailsResponse(invoiceRepository.save(invoice));

        return new ResponseEntity<>(ResponseHelper.CREATE(response), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse<List<InvoiceDetailsResponse>>> getInvoicesByUser(String userId) {
        AuthenticatedUserInfo authInfo = getAuthenticatedUserInfo();

        if (!authInfo.isAdmin() && !authInfo.userId().equals(userId)) {
            return new ResponseEntity<>(ResponseHelper.ERROR("Access denied"), HttpStatus.FORBIDDEN);
        }

        List<InvoiceDetailsResponse> responseList = invoiceRepository
                .findAllByUserUserId(userId)
                .stream()
                .map(converter::fromInvoiceEntityToDetailsResponse)
                .toList();

        return new ResponseEntity<>(ResponseHelper.CREATE(responseList), HttpStatus.OK);
    }


    private AuthenticatedUserInfo getAuthenticatedUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !(authentication.getPrincipal() instanceof UserDetails userDetails)) {
            throw new RuntimeException("Authentication information not found");
        }

        String username = userDetails.getUsername();
        User userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Not found user"));

        boolean isAdmin = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch("ADMIN"::equals);

        return new AuthenticatedUserInfo(userEntity.getUserId(), isAdmin);
    }


    private record AuthenticatedUserInfo(String userId, boolean isAdmin) {
    }
}
