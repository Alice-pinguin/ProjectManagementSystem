package ua.goit.Repository;

import ua.goit.model.BaseEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<E extends BaseEntity<ID>, ID> {

    public E getOne(ID id);

    public List<E> saveAll(Iterable<E> itrbl);

    public Collection<E> findAll();

    public void deleteAll();

    public void deleteById(ID id);

    public boolean existsById(ID id);

    public Optional<E> findById(ID id);

    public E save(E e);
}
