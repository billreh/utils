package net.tralfamadore;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;

/**
 * Class: JaxBTest
 * Created by billreh on 4/29/17.
 */
public class JaxBTest {
    @Test
    public void testJaxB() throws Exception {
        Person person = new Person();
        person.setId(0L);
        person.setName("Mr. Dog");
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(person, stringWriter);
        System.out.println(stringWriter.toString());

        System.out.println(JaxUtils.toXxml(person));
    }

    @XmlRootElement
    static class Person {
        private Long id;
        private String name;


        public Long getId() {
            return id;
        }

        @XmlElement
        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        @XmlElement
        public void setName(String name) {
            this.name = name;
        }
    }
}
