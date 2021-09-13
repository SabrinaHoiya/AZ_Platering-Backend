package com.example.AZplastering.repository;

import com.example.AZplastering.models.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository  extends JpaRepository<Mail,Long> {
}
