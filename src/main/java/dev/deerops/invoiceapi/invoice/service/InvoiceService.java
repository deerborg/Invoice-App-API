package dev.deerops.invoiceapi.invoice.service;

import dev.deerops.invoiceapi.common.util.result.ApiResponse;
import dev.deerops.invoiceapi.invoice.model.dto.request.CreateInvoiceRequest;
import dev.deerops.invoiceapi.invoice.model.dto.response.InvoiceDetailsResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InvoiceService {

    ResponseEntity<ApiResponse<InvoiceDetailsResponse>> createInvoice(CreateInvoiceRequest request);
    ResponseEntity<ApiResponse<List<InvoiceDetailsResponse>>> getInvoicesByUser(String userId);

}
