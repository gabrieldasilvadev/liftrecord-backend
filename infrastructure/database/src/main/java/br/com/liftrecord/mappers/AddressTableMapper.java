package br.com.liftrecord.mappers;

import br.com.liftrecord.student.valueobjects.Address;
import br.com.liftrecord.tables.AddressTable;
import de.huxhorn.sulky.ulid.ULID;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressTableMapper {
  AddressTableMapper INSTANCE = Mappers.getMapper(AddressTableMapper.class);

  default AddressTable toTable(Address address) {
    return AddressTable.builder()
        .id(new ULID().nextULID())
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
