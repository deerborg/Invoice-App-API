package dev.deerops.invoiceapi.invoice.model.dto.request;

public class CreateInvoiceRequest {

    private String customerName;

    private String customerEmail;

    private Double totalAmount;

    private Double taxAmount;

    private Double subTotal;

    private String details;

    private String userId;


    public CreateInvoiceRequest(String customerName, String customerEmail, Double totalAmount, Double taxAmount, Double subTotal, String details, String userId) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.totalAmount = totalAmount;
        this.taxAmount = taxAmount;
        this.subTotal = subTotal;
        this.details = details;
        this.userId = userId;
    }

    public CreateInvoiceRequest() {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
