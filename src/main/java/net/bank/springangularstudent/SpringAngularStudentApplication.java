package net.bank.springangularstudent;

import net.bank.springangularstudent.entities.Payment;
import net.bank.springangularstudent.entities.PaymentStatus;
import net.bank.springangularstudent.entities.PaymentType;
import net.bank.springangularstudent.entities.Student;
import net.bank.springangularstudent.repository.PaymentRepository;
import net.bank.springangularstudent.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;
import java.util.function.Consumer;

@SpringBootApplication
public class SpringAngularStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAngularStudentApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                        PaymentRepository paymentRepository){
        return args -> {
            studentRepository.save(Student.builder()
                    .id(UUID.randomUUID().toString())
                    .firstName("Khalid")
                    .lastName("Morabet")
                    .code("142569")
                    .programId("MDI").build());
            studentRepository.save(Student.builder()
                    .id(UUID.randomUUID().toString())
                    .firstName("Adam")
                    .lastName("Yehyaoui")
                    .code("52963")
                    .programId("DDI").build());
            studentRepository.save(Student.builder()
                    .id(UUID.randomUUID().toString())
                    .firstName("Anass")
                    .lastName("Abid")
                    .code("10258")
                    .programId("MDI").build());
            studentRepository.save(Student.builder()
                    .id(UUID.randomUUID().toString())
                    .firstName("Lamya")
                    .lastName("ferhaoui")
                    .code("52687")
                    .programId("DDI").build());
            PaymentType[] paymentTypes=PaymentType.values();
            System.out.println(paymentTypes.length);
            Random random=new Random();
            System.out.println(random);
            studentRepository.findAll().forEach(st ->{
                for (int i=0; i<10; i++){
                    int index = random.nextInt(paymentTypes.length);
                    System.out.println(index);
                    Payment payment=Payment.builder()
                            .amount(1000+(int)(Math.random()+20000))
                            .type(paymentTypes[index])
                            .status(PaymentStatus.CREATED)
                            .date(LocalDate.now())
                            .student(st)
                            .build();
                    paymentRepository.save(payment);
                }
            });

        };
    }

}
