package facade;


import entity.Person;
import java.util.List;

public interface FacadeInterface
{
    public Person getPerson(Long id);
    public Person addPerson(Person u);
    public Person deletePerson(Long id);
    public Person editPerson(Person u);
    public List<Person> getPersons();
}