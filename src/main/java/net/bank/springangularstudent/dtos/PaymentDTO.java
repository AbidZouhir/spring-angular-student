package net.bank.springangularstudent.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import net.bank.springangularstudent.entities.PaymentStatus;
import net.bank.springangularstudent.entities.PaymentType;
import net.bank.springangularstudent.entities.Student;

import java.time.LocalDate;
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
@Builder
public class PaymentDTO {
    private Long id;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private PaymentStatus status;

}
