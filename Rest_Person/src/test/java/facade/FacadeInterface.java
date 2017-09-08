/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sanox
 */
public class FacadeInterface {

    private Facade f;

    public FacadeInterface() {
        this.f = new Facade(Persistence.createEntityManagerFactory("PU"));
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetPersonWithID() {

        Person p = f.getPerson(1L);
        Person p2 = f.getPerson(2L);
        String expected = "Tobias";
        String expected2 = "Victor";
        assertEquals(p.getFirstName(), expected);
        assertEquals(p2.getFirstName(), expected2);
    }

    @Test
    public void testAddPersonObject() {
        Person add = new Person();
        add.setId(55L);
        add.setFirstName("test");
        add.setLastName("test");
        add.setPhone(66666666);

        f.addPerson(add);

        Person get = f.getPerson(55L);

        assertEquals(add.getFirstName(), get.getFirstName());

        f.deletePerson(55L);
    }

    @Test (expected = NullPointerException.class) 
    public void testDeletePerson() {

        Person add = new Person();
        add.setId(75L);
        add.setFirstName("test");
        add.setLastName("test");
        add.setPhone(66666666);

        f.addPerson(add);
        Person get = f.getPerson(75L);
        assertEquals(add.getFirstName(), get.getFirstName());

        f.deletePerson(75L);
        
        Person removed = f.getPerson(75L);
        assertNull(removed);

    }

    @Test
    public void testEditPerson() {

    }

    @Test
    public void testGetAllPersons() {

    }

}
