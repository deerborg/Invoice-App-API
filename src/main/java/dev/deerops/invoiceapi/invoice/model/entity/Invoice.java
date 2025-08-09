package dev.deerops.invoiceapi.invoice.model.entity;

import dev.deerops.invoiceapi.user.model.entity.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    private String customerName;

    private String customerEmail;

    private String totalAmount;

    private Double taxAmount;

    private Double subTotal;

    private String details;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;




    public Invoice(Long invoiceId, String customerName, String customerEmail, String totalAmount, Double taxAmount, Double subTotal, String details, LocalDateTime createdAt, User user) {
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.totalAmount = totalAmount;
        this.taxAmount = taxAmount;
        this.subTotal = subTotal;
        this.details = details;
        this.createdAt = createdAt;
        this.user = user;
    }

    public Invoice() {
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

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Invoice invoice = (Invoice) object;
        return invoiceId.equals(invoice.invoiceId) && customerName.equals(invoice.customerName) && customerEmail.equals(invoice.customerEmail) && totalAmount.equals(invoice.totalAmount) && taxAmount.equals(invoice.taxAmount) && subTotal.equals(invoice.subTotal) && details.equals(invoice.details) && createdAt.equals(invoice.createdAt) && user.equals(invoice.user);
    }

    @Override
    public int hashCode() {
        int result = invoiceId.hashCode();
        result = 31 * result + customerName.hashCode();
        result = 31 * result + customerEmail.hashCode();
        result = 31 * result + totalAmount.hashCode();
        result = 31 * result + taxAmount.hashCode();
        result = 31 * result + subTotal.hashCode();
        result = 31 * result + details.hashCode();
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}
