package br.com.liftrecord.factory;

import br.com.liftrecord.account.valueobjects.Cellphone;
import br.com.liftrecord.account.valueobjects.Contact;
import br.com.liftrecord.account.valueobjects.Email;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

public class ContactFactory {
  public static final Model<Contact> CONTACT_MODEL = Instancio.of(Contact.class)
      .lenient()
      .generate(field(Email::getValue), gen -> gen.net().email())
      .generate(field(Cellphone::getDdd), gen -> gen.ints().range(11, 99).asString())
      .generate(field(Cellphone::getNumber), gen -> gen.ints().range(10000000, 99999999).asString())
      .toModel();

  public static Contact withEmail(String email) {
    return Instancio.of(CONTACT_MODEL)
        .set(field(Email::getValue), email)
        .create();
  }
}
