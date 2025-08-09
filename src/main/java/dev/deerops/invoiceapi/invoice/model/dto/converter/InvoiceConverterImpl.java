package dev.deerops.invoiceapi.invoice.model.dto.converter;

import dev.deerops.invoiceapi.invoice.model.dto.request.CreateInvoiceRequest;
import dev.deerops.invoiceapi.invoice.model.dto.response.InvoiceDetailsResponse;
import dev.deerops.invoiceapi.invoice.model.dto.response.InvoiceResponse;
import dev.deerops.invoiceapi.invoice.model.entity.Invoice;
import org.springframework.stereotype.Component;

@Component
public class InvoiceConverterImpl implements InvoiceConverter{


    @Override
    public Invoice fromCreateInvoiceRequest(CreateInvoiceRequest request){

        Invoice invoice = new Invoice();

        invoice.setCustomerName(request.getCustomerName());
        invoice.setCustomerEmail(request.getCustomerEmail());
        invoice.setTotalAmount(request.getTotalAmount());
        invoice.setTaxAmount(request.getTaxAmount());
        invoice.setSubTotal(request.getSubTotal());
        invoice.setDetails(request.getDetails());

        return invoice;
    }

    @Override
    public InvoiceResponse fromInvoiceEntityToDefaultResponse(Invoice entity){

        InvoiceResponse response = new InvoiceResponse();

        response.setInvoiceId(entity.getInvoiceId());
        response.setCreatedAt(entity.getCreatedAt());


        return response;
    }

    @Override
    public InvoiceDetailsResponse fromInvoiceEntityToDetailsResponse(Invoice entity){

        InvoiceDetailsResponse response = new InvoiceDetailsResponse();

        response.setInvoiceId(entity.getInvoiceId());
        response.setCustomerName(entity.getCustomerName());
        response.setCustomerEmail(entity.getCustomerEmail());
        response.setTotalAmount(entity.getTotalAmount());
        response.setTaxAmount(entity.getTaxAmount());
        response.setSubTotal(entity.getSubTotal());
        response.setCreatedAt(entity.getCreatedAt());
        response.setDetails(entity.getDetails());

        return response;

    }







}
