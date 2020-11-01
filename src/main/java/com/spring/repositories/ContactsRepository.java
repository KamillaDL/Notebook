package com.spring.repositories;

import com.spring.domain.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactsRepository extends JpaRepository<Contact, Long>{
//    List<Contact> findByUserId(Integer user_id, Pageable pageable);
    Page<Contact> findByUserId(Integer user_id, Pageable pageable);
    Contact findById(Integer id);
}
