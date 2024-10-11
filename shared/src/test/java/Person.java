import br.com.liftrecord.domain.DomainObject;
import java.time.LocalDate;

public class Person extends DomainObject {
        private final String name;
        private final String surname;
        private int age;

        public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public void setBirthDate(LocalDate  birthDate) {
            this.age = LocalDate.now().getYear() - birthDate.getYear();
        }

    public int getAge() {
        return age;
    }
}