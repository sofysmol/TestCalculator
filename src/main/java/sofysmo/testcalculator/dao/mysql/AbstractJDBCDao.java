package sofysmo.testcalculator.dao.mysql;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sofysmo.testcalculator.dao.GenericDao;

import sofysmo.testcalculator.data.Identified;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by sofysmo on 19.12.16.
 */
public abstract class AbstractJDBCDao <T extends Identified<Integer>> implements GenericDao<T, Integer> {

    private DataSource dataSource;
    protected JdbcTemplate jdbcTemplate;
    
    
    public AbstractJDBCDao(DataSource dataSource){
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    protected abstract RowMapper<T> getMapper();
    protected abstract String queryForUpdate(T object);
    protected abstract String queryForPersist(T object);
    protected abstract String queryForDelete(T object);
    protected abstract String tableName();

    /** Создает новую запись, соответствующую объекту object */
    @Override
    public T persist(T object){
        jdbcTemplate.update(queryForPersist(object));
        return getByPK(object.getId());
    }


    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    @Override
    public T getByPK(Integer key){
        List<T> res = jdbcTemplate.query("select * from "+tableName()+" where id = "+ key, getMapper());
        if(res.size()>0) return res.get(0);
        else return  null;
    }

    /** Сохраняет состояние объекта group в базе данных */
    @Override
    public T update(T object){
        jdbcTemplate.update(queryForUpdate(object));
        return getByPK(object.getId());
    }

    /** Удаляет запись об объекте из базы данных */
    @Override
    public void delete(T object){
        jdbcTemplate.update(queryForDelete(object));
    }

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    @Override
    public List<T> getAll() {
        return jdbcTemplate.query("select * from " + tableName(), getMapper());
    }
}
