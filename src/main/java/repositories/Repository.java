package repositories;

import java.util.Set;

public interface Repository<T> {

    T find(int id);

    void create(T t);

    T read(final int id);

    void update(T t);

    void delete(T t);

    Set<T> getAll();




}
