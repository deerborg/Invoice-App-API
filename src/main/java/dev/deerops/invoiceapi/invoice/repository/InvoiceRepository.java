package dev.deerops.invoiceapi.invoice.repository;

import dev.deerops.invoiceapi.invoice.model.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
    List<Invoice> findAllByUserUserId(String userId);
}
