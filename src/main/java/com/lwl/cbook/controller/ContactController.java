package com.lwl.cbook.controller;

import com.lwl.cbook.dto.ContactDto;
import com.lwl.cbook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
      @Autowired
      private ContactService contactService;
      @GetMapping("/all")
      public ResponseEntity<List<ContactDto>> getContacts(){
            return ResponseEntity.ok(contactService.getContacts());
      }
}
