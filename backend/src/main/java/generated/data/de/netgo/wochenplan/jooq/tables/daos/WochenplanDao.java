/*
 * This file is generated by jOOQ.
 */
package de.netgo.wochenplan.jooq.tables.daos;


import de.netgo.wochenplan.jooq.tables.Wochenplan;
import de.netgo.wochenplan.jooq.tables.records.WochenplanRecord;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
@Repository
public class WochenplanDao extends DAOImpl<WochenplanRecord, de.netgo.wochenplan.jooq.tables.pojos.Wochenplan, UUID> {

    /**
     * Create a new WochenplanDao without any configuration
     */
    public WochenplanDao() {
        super(Wochenplan.WOCHENPLAN, de.netgo.wochenplan.jooq.tables.pojos.Wochenplan.class);
    }

    /**
     * Create a new WochenplanDao with an attached configuration
     */
    @Autowired
    public WochenplanDao(Configuration configuration) {
        super(Wochenplan.WOCHENPLAN, de.netgo.wochenplan.jooq.tables.pojos.Wochenplan.class, configuration);
    }

    @Override
    public UUID getId(de.netgo.wochenplan.jooq.tables.pojos.Wochenplan object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<de.netgo.wochenplan.jooq.tables.pojos.Wochenplan> fetchRangeOfId(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(Wochenplan.WOCHENPLAN.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<de.netgo.wochenplan.jooq.tables.pojos.Wochenplan> fetchById(UUID... values) {
        return fetch(Wochenplan.WOCHENPLAN.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public de.netgo.wochenplan.jooq.tables.pojos.Wochenplan fetchOneById(UUID value) {
        return fetchOne(Wochenplan.WOCHENPLAN.ID, value);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Optional<de.netgo.wochenplan.jooq.tables.pojos.Wochenplan> fetchOptionalById(UUID value) {
        return fetchOptional(Wochenplan.WOCHENPLAN.ID, value);
    }

    /**
     * Fetch records that have <code>benutzer_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<de.netgo.wochenplan.jooq.tables.pojos.Wochenplan> fetchRangeOfBenutzerId(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(Wochenplan.WOCHENPLAN.BENUTZER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>benutzer_id IN (values)</code>
     */
    public List<de.netgo.wochenplan.jooq.tables.pojos.Wochenplan> fetchByBenutzerId(UUID... values) {
        return fetch(Wochenplan.WOCHENPLAN.BENUTZER_ID, values);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<de.netgo.wochenplan.jooq.tables.pojos.Wochenplan> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Wochenplan.WOCHENPLAN.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<de.netgo.wochenplan.jooq.tables.pojos.Wochenplan> fetchByName(String... values) {
        return fetch(Wochenplan.WOCHENPLAN.NAME, values);
    }
}
