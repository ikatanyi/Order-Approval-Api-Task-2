package com.castille.order.model.specification;

import com.castille.customer.model.Customer;
import com.castille.customer.model.enumeration.Gender;
import com.castille.order.model.Order;
import com.castille.order.model.enumeration.Status;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;

/**
 * Filters for searching the data and filtering for the user
 *
 * @author Kelsas
 */
public class OrderSpecification {

    public OrderSpecification() {
        super();
    }

    public static Specification<Order> createSpecification(Status status, Long customerId, String productName, String packageName) {
        return (root, query, cb) -> {
            final ArrayList<Predicate> predicates = new ArrayList<>();

            if(status!=null) {
                predicates.add(cb.equal(root.get("status"), status));
            }

            if (customerId!=null) {
                predicates.add(cb.equal(root.get("customer").get("id"), customerId ));
            }

            if (productName != null) {
                String exp = "%" + productName + "%";
                predicates.add(cb.like(root.get("product").get("description"), exp));
            }
            if (packageName != null) {
                String exp = "%" + packageName + "%";
                predicates.add(cb.like(root.get("productPackage").get("description"), exp));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
