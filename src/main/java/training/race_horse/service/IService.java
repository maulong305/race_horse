package training.race_horse.service;

public interface IService<T> {
    Iterable<T> findAll();
    T findById(Long id);
    void remove(Long id);
    T save(T t);
}
