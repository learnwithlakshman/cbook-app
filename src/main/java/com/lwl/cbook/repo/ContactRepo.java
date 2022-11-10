package com.lwl.cbook.repo;

import com.lwl.cbook.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact,Long> {
}
