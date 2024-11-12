package br.com.liftrecord.factory;

import br.com.liftrecord.valueobjects.Address;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

public class AddressFactory {
  public static final Model<Address> ADDRESS_MODEL = Instancio.of(Address.class)
      .generate(field(Address::state), gen -> gen.oneOf("sp"))
      .generate(field(Address::zipCode), gen -> gen.string().minLength(8).maxLength(8))
      .generate(field(Address::number), gen -> gen.string().minLength(1).maxLength(10))
      .toModel();
}
