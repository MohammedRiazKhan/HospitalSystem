package repositories;

public interface  Repository<T, ID> {

    void create(T t);

    T read(ID id);

    void update(T t);

    void delete(ID id);

}
