package me.aitbahaa.companyservice;

import me.aitbahaa.companyservice.dao.CompanyRepository;
import me.aitbahaa.companyservice.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.stream.Stream;

@SpringBootApplication
public class CompanyServiceApplication {
    @Autowired
    private CompanyRepository companyRepository;

    public static void main(String[] args) {
        SpringApplication.run(CompanyServiceApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    private void startup() {
        Stream.of("Sango", "Apple", "Samsung", "Xiaomi", "Microsoft", "HP", "Toshiba", "Asus", "MSI")
                .map(companyName -> new Company(null, companyName))
                .forEach(companyRepository::save);
    }
}

