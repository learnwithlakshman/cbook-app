package com.lwl.cbook.service;

import com.lwl.cbook.dto.ContactDto;
import com.lwl.cbook.repo.ContactRepo;
import com.lwl.cbook.util.ContactConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
  @Autowired
  private ContactRepo contactRepo;

  @Override
  public List<ContactDto> getContacts() {
    return contactRepo.findAll().stream().map(ContactConvertor::toDto).collect(Collectors.toList());
  }
}
