package com.keresman.worms.utility;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public final class JAXBUtils {

    private JAXBUtils() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    public static <T> void save(T t, String filename) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(t.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(t, new File(filename));
    }

    public static <T> T load(Class<T> clazz, String filename) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new File(filename));
    }
}
