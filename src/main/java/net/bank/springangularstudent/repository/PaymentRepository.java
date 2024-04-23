package net.bank.springangularstudent.repository;

import net.bank.springangularstudent.entities.Payment;
import net.bank.springangularstudent.entities.PaymentStatus;
import net.bank.springangularstudent.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);
}
