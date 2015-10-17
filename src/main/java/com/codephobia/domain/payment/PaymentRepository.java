package com.codephobia.domain.payment;

import com.codephobia.domain.request.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by waldo on 2015-10-17.
 */

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
