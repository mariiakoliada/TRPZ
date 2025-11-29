package ia32.koliada.finance.repository;
import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
    void save(T entity);
    Optional<T> findById(Long id);
    List<T> findAll(); // Метод для вибірки всіх записів
}
