package database.mappers;

import database.tables.AddressTable;
import br.com.liftrecord.domain.student.valueobjects.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressTableMapper {
  AddressTableMapper INSTANCE = Mappers.getMapper(AddressTableMapper.class);

  default AddressTable toTable(Address address) {
    return AddressTable.builder()
        .street(address.getStreet())
        .number(address.getNumber())
        .neighborhood(address.getNeighborhood())
        .complement(address.getComplement())
        .city(address.getCity())
        .state(address.getState())
        .zipCode(address.getZipCode())
        .build();
  }
}
