package net.bank.springangularstudent.web;

import lombok.AllArgsConstructor;
import net.bank.springangularstudent.entities.Payment;
import net.bank.springangularstudent.entities.PaymentStatus;
import net.bank.springangularstudent.entities.PaymentType;
import net.bank.springangularstudent.entities.Student;
import net.bank.springangularstudent.repository.PaymentRepository;
import net.bank.springangularstudent.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PaymentRestController {
    private StudentRepository studentRepository;
    private PaymentRepository paymentRepository;

    @GetMapping(path = "/payments")
    public List<Payment> allPayments(){
        return paymentRepository.findAll();
    }

    @GetMapping(path = "/students/{code}/payments")
    public List<Payment> paymentsByStudent(@PathVariable String code){
        return paymentRepository.findByStudentCode(code);
    }

    @GetMapping(path = "/payments/byStatus")
    public List<Payment> paymentsByStatus(@RequestParam PaymentStatus status){
        return paymentRepository.findByStatus(status);
    }
    @GetMapping(path = "/payments/byType")
    public List<Payment> paymentsByType(@RequestParam PaymentType type){
        return paymentRepository.findByType(type);
    }

    @GetMapping(path = "/payments/{id}")
    public Payment getPaymentById(@PathVariable Long id){
        return paymentRepository.findById(id).get();
    }

    @GetMapping(path = "/students")
    public List<Student> allStudents(){
        return studentRepository.findAll();
    }

    @GetMapping(path = "/students/{code}")
    public Student getstudentByCode(@PathVariable String code){
        return studentRepository.findByCode(code);
    }

    @GetMapping(path = "/studentsByProgramId")
    public List<Student> getStudentByProgramId(@RequestParam String programId){
        return studentRepository.findByProgramId(programId);
    }
}
