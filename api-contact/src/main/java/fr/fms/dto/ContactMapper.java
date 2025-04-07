package fr.fms.dto;

import fr.fms.entities.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    @Mappings({
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "company", target = "company"),
            @Mapping(source = "jobTitle", target = "jobTitle"),
            @Mapping(source = "birthday", target = "birthday")
    })

    Contact contactDtoToContact(ContactDto contactDto);

}
