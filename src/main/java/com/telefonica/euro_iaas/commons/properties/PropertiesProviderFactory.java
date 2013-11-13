package com.telefonica.euro_iaas.commons.properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Creates PropertiesUtils objects.
 *
 * @author Sergio Arroyo
 *
 */
public interface PropertiesProviderFactory {

    /**
     * Creates a properties util object.
     *
     * <p>The returned properties util is <b>NOT</b> transactional, so clients
     * should handle transactions manually.</p>
     *
     * @param em Entity manager needed to connect with the underlying database
     *
     * @return A valid <b>NON</b> transactional properties util object.
     *
     * @throws PropertiesProviderRuntimeException If any error happens
     */
    PropertiesProvider createPropertiesProvider(EntityManager em)
            throws PropertiesProviderRuntimeException;



    /**
     * Creates a properties util object.
     *
     * <p>The returned properties util <b>IS</b> transactional. Transactional
     * properties utils open new transaction (or attach to existing
     * transactions) for every call to store method.</p>
     *
     * @param emf Entity manager factory that provides access to the entity
     * manager
     *
     * @return A valid transactional properties util object.
     *
     * @throws PropertiesProviderRuntimeException If any error happens
     */
    PropertiesProvider createPropertiesProvider(EntityManagerFactory emf)
            throws PropertiesProviderRuntimeException;


}