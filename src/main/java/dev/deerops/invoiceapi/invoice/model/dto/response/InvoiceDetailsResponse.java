package dev.deerops.invoiceapi.invoice.model.dto.response;

import java.time.LocalDateTime;

public class InvoiceDetailsResponse {

    private Long invoiceId;

    private String customerName;

    private String customerEmail;

    private Double totalAmount;

    private Double taxAmount;

    private Double subTotal;

    private String details;

    private LocalDateTime createdAt;


    public InvoiceDetailsResponse(Long invoiceId, String customerName, String customerEmail, Double totalAmount, Double taxAmount, Double subTotal, String details, LocalDateTime createdAt) {
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.totalAmount = totalAmount;
        this.taxAmount = taxAmount;
        this.subTotal = subTotal;
        this.details = details;
        this.createdAt = createdAt;
    }


    public InvoiceDetailsResponse() {
    }


    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
