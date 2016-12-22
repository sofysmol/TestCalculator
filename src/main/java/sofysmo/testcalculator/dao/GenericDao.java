package sofysmo.testcalculator.dao;

/**
 * Created by sofysmo on 19.12.16.
 */
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Унифицированный интерфейс управления персистентным состоянием объектов
 * @param <T> тип объекта персистенции
 * @param <PK> тип первичного ключа
 */
public interface GenericDao<T, PK> {

    /** Создает новую запись, соответствующую объекту object */
    public T persist(T object);

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public T getByPK(PK key);

    /** Сохраняет состояние объекта group в базе данных */
    public T update(T object);

    /** Удаляет запись об объекте из базы данных */
    public void delete(T object);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<T> getAll();
}
