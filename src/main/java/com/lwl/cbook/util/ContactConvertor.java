package com.lwl.cbook.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwl.cbook.domain.Contact;
import com.lwl.cbook.dto.ContactDto;

public class ContactConvertor {

    public static Contact toDomain(ContactDto contactDto){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(contactDto,Contact.class);
    }
    public static ContactDto toDto(Contact contact){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(contact,ContactDto.class);
    }

}
