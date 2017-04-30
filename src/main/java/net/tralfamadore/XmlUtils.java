package net.tralfamadore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Class: XmlUtils
 * Created by billreh on 4/29/17.
 */
@SuppressWarnings("WeakerAccess")
public class XmlUtils {
    public static String toXxml(Object bean) {
        StringWriter stringWriter = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(bean.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            stringWriter = new StringWriter();
            marshaller.marshal(bean, stringWriter);
            String result = stringWriter.toString();
            // remove xml declaration
            result = result.replaceFirst(".*\n", "");
            return result;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } finally {
            if(stringWriter != null)
                try {
                    stringWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
