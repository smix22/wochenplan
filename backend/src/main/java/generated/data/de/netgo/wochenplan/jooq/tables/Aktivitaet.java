/*
 * This file is generated by jOOQ.
 */
package de.netgo.wochenplan.jooq.tables;


import de.netgo.wochenplan.jooq.Keys;
import de.netgo.wochenplan.jooq.Public;
import de.netgo.wochenplan.jooq.tables.Wochenplan.WochenplanPath;
import de.netgo.wochenplan.jooq.tables.records.AktivitaetRecord;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Aktivitaet extends TableImpl<AktivitaetRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.aktivitaet</code>
     */
    public static final Aktivitaet AKTIVITAET = new Aktivitaet();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AktivitaetRecord> getRecordType() {
        return AktivitaetRecord.class;
    }

    /**
     * The column <code>public.aktivitaet.id</code>.
     */
    public final TableField<AktivitaetRecord, UUID> ID = createField(DSL.name("id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.aktivitaet.wochenplan_id</code>.
     */
    public final TableField<AktivitaetRecord, UUID> WOCHENPLAN_ID = createField(DSL.name("wochenplan_id"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.aktivitaet.name</code>.
     */
    public final TableField<AktivitaetRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.aktivitaet.wochentag</code>.
     */
    public final TableField<AktivitaetRecord, String> WOCHENTAG = createField(DSL.name("wochentag"), SQLDataType.VARCHAR(10), this, "");

    private Aktivitaet(Name alias, Table<AktivitaetRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Aktivitaet(Name alias, Table<AktivitaetRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.aktivitaet</code> table reference
     */
    public Aktivitaet(String alias) {
        this(DSL.name(alias), AKTIVITAET);
    }

    /**
     * Create an aliased <code>public.aktivitaet</code> table reference
     */
    public Aktivitaet(Name alias) {
        this(alias, AKTIVITAET);
    }

    /**
     * Create a <code>public.aktivitaet</code> table reference
     */
    public Aktivitaet() {
        this(DSL.name("aktivitaet"), null);
    }

    public <O extends Record> Aktivitaet(Table<O> path, ForeignKey<O, AktivitaetRecord> childPath, InverseForeignKey<O, AktivitaetRecord> parentPath) {
        super(path, childPath, parentPath, AKTIVITAET);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class AktivitaetPath extends Aktivitaet implements Path<AktivitaetRecord> {
        public <O extends Record> AktivitaetPath(Table<O> path, ForeignKey<O, AktivitaetRecord> childPath, InverseForeignKey<O, AktivitaetRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private AktivitaetPath(Name alias, Table<AktivitaetRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public AktivitaetPath as(String alias) {
            return new AktivitaetPath(DSL.name(alias), this);
        }

        @Override
        public AktivitaetPath as(Name alias) {
            return new AktivitaetPath(alias, this);
        }

        @Override
        public AktivitaetPath as(Table<?> alias) {
            return new AktivitaetPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<AktivitaetRecord> getPrimaryKey() {
        return Keys.AKTIVITAET_PKEY;
    }

    @Override
    public List<ForeignKey<AktivitaetRecord, ?>> getReferences() {
        return Arrays.asList(Keys.AKTIVITAET__AKTIVITAET_WOCHENPLAN_ID_FKEY);
    }

    private transient WochenplanPath _wochenplan;

    /**
     * Get the implicit join path to the <code>public.wochenplan</code> table.
     */
    public WochenplanPath wochenplan() {
        if (_wochenplan == null)
            _wochenplan = new WochenplanPath(this, Keys.AKTIVITAET__AKTIVITAET_WOCHENPLAN_ID_FKEY, null);

        return _wochenplan;
    }

    @Override
    public Aktivitaet as(String alias) {
        return new Aktivitaet(DSL.name(alias), this);
    }

    @Override
    public Aktivitaet as(Name alias) {
        return new Aktivitaet(alias, this);
    }

    @Override
    public Aktivitaet as(Table<?> alias) {
        return new Aktivitaet(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Aktivitaet rename(String name) {
        return new Aktivitaet(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Aktivitaet rename(Name name) {
        return new Aktivitaet(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Aktivitaet rename(Table<?> name) {
        return new Aktivitaet(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Aktivitaet where(Condition condition) {
        return new Aktivitaet(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Aktivitaet where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Aktivitaet where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Aktivitaet where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Aktivitaet where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Aktivitaet where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Aktivitaet where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Aktivitaet where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Aktivitaet whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Aktivitaet whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
