package com.castille.order.model;

import com.castille.customer.model.Customer;
import com.castille.order.data.OrderDto;
import com.castille.order.model.enumeration.Status;
import com.castille.product.data.ProductDto;
import com.castille.pkg.model.ProductPackage;
import com.castille.product.model.Product;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Table(name = "orders")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private LocalDateTime installationTime;
    private String installationAddress;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "product_package_id")
    private ProductPackage productPackage;
    @Enumerated(EnumType.STRING)
    private Status status;


    public OrderDto toOrderDto(){
        OrderDto orderDto = new OrderDto();
        orderDto.setId(this.getId());
        orderDto.setCustomerId(this.getCustomer().getId());
        orderDto.setInstallationTime(this.getInstallationTime());
        orderDto.setInstallationAddress(this.getInstallationAddress());
        orderDto.setProductId(this.getProduct().getId());
        orderDto.setProductPackageId(this.getProductPackage().getId());
        orderDto.setProductName(this.getProduct().getDescription());
        orderDto.setProductPackage(this.getProductPackage().getDescription());
        orderDto.setCustomerName(this.getCustomer().getFirstName() + " " + this.getCustomer().getLastName());
        orderDto.setStatus(this.getStatus());
        return orderDto;
    }

    public String toEmailOrder(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order placed on: " + LocalDate.now()+ "\n");
        sb.append("Product: " + this.getProduct().getDescription() + "\n");
        sb.append("Product Package: " + this.getProductPackage().getDescription() + "\n");
        sb.append("Customer: " + this.getCustomer().getFirstName() + " " + this.getCustomer().getLastName() + "\n");
        sb.append("Installation Address: " + this.getInstallationAddress() + "\n");
        sb.append("Installation Date: " + this.getInstallationTime() + " at " + this.getInstallationAddress() + "\n");
        return sb.toString();

    }
}
