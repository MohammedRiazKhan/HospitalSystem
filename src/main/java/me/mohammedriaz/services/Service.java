package me.mohammedriaz.services;

public interface Service<T, ID> {

    T create(T t);

    T read(ID id);

    T update(T t);

    void delete(ID id);

}
