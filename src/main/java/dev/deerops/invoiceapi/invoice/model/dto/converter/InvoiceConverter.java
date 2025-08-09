package dev.deerops.invoiceapi.invoice.model.dto.converter;

import dev.deerops.invoiceapi.invoice.model.dto.request.CreateInvoiceRequest;
import dev.deerops.invoiceapi.invoice.model.dto.response.InvoiceDetailsResponse;
import dev.deerops.invoiceapi.invoice.model.dto.response.InvoiceResponse;
import dev.deerops.invoiceapi.invoice.model.entity.Invoice;

public interface InvoiceConverter {
    Invoice fromCreateInvoiceRequest(CreateInvoiceRequest request);

    InvoiceResponse fromInvoiceEntityToDefaultResponse(Invoice entity);

    InvoiceDetailsResponse fromInvoiceEntityToDetailsResponse(Invoice entity);
}
