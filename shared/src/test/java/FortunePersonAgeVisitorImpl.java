import br.com.liftrecord.visitor.Visitor;
import java.time.LocalDate;

public class FortunePersonAgeVisitorImpl implements Visitor<Person> {
    @Override
    public void visit(Person domainObject) {
        domainObject.setBirthDate(LocalDate.of(2000, 1, 1));
    }
}
