package dev.deerops.invoiceapi.invoice.controller;

import dev.deerops.invoiceapi.common.util.result.ApiResponse;
import dev.deerops.invoiceapi.invoice.model.dto.request.CreateInvoiceRequest;
import dev.deerops.invoiceapi.invoice.model.dto.response.InvoiceDetailsResponse;
import dev.deerops.invoiceapi.invoice.service.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/private")
    public ResponseEntity<ApiResponse<InvoiceDetailsResponse>> createInvoice(@RequestBody CreateInvoiceRequest request){
        return invoiceService.createInvoice(request);
    }


    @GetMapping("/private/user/{userId}")
    public ResponseEntity<ApiResponse<List<InvoiceDetailsResponse>>> getInvoicesByUser(@PathVariable String userId){
        return invoiceService.getInvoicesByUser(userId);
    }
}
