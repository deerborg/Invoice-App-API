package dev.deerops.invoiceapi.invoice.model.dto.response;

import java.time.LocalDateTime;

public class InvoiceResponse {

    private Long invoiceId;

    private LocalDateTime createdAt;


    public InvoiceResponse(Long invoiceId, LocalDateTime createdAt) {
        this.invoiceId = invoiceId;
        this.createdAt = createdAt;
    }

    public InvoiceResponse() {
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
