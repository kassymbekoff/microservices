package io.github.kassymbekoff.customer.repositories;

import io.github.kassymbekoff.customer.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
