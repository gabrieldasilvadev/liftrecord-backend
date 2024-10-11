import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FortuneDomainObjectWithVisitorTest {

    @Test
    @DisplayName("Should fortune a domain object when fortune a visitor")
    void shouldFortuneADomainObjectWhenFortuneAVisitor() {
        Person person = new Person("John", "Doe");
        FortunePersonAgeVisitorImpl visitor = new FortunePersonAgeVisitorImpl();

        person.accept(visitor);

        assert person.getName().equals("John");
        assert person.getSurname().equals("Doe");
        assert person.getAge() == 24;
    }
}
