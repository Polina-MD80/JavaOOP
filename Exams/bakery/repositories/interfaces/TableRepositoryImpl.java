package bakery.repositories.interfaces;

import bakery.entities.tables.interfaces.Table;

import java.util.*;

import static bakery.common.ExceptionMessages.TABLE_EXIST;

public class TableRepositoryImpl implements TableRepository<Table>{
    private final Collection<Table> models;

    public TableRepositoryImpl() {

        this.models = new ArrayList<>();
    }

    @Override
    public Table getByNumber(int number) {

        return this.models.stream().filter(e -> e.getTableNumber() == number).findFirst().orElse(null);
    }

    @Override
    public Collection<Table> getAll() {

        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Table table) {
        this.models.add(table);
    }


}
