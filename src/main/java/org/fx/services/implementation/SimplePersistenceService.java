package org.fx.services.implementation;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.fx.services.PersistenceService;
import org.slf4j.Logger;

@Singleton
public class SimplePersistenceService implements PersistenceService {
    @Inject
    private Logger logger;

    @Override
    public Object load(final File file, final Class<?> clasz) {
        try {
            final JAXBContext context = JAXBContext.newInstance(clasz);
            final Unmarshaller unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(file);
        } catch (final Exception e) {
            logger.error("{}", e.getMessage());
        }

        return null;
    }

    @Override
    public void save(final File file, final Object object) {
        try {
            final JAXBContext context = JAXBContext.newInstance(object.getClass());
            final Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(object, file);
        } catch (final Exception e) {
            logger.error("{}", e.getMessage());
        }
    }

    @PostConstruct
    public void init() {
        logger.info("Initializing persistence service");
    }

    @PreDestroy
    public void cleanup() {
        logger.info("Closing persistence service");
    }
}
