package io.digiwise.ihmmt.repository;

import io.digiwise.ihmmt.model.Event;
import io.digiwise.ihmmt.model.ObjectifType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ObjectifTypeRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class ObjectifTypeRowMapper implements RowMapper<ObjectifType> {
        @Override
        public ObjectifType mapRow(ResultSet rs, int rowNum) throws SQLException {
            ObjectifType objectifType = new ObjectifType();
            objectifType.setId(rs.getLong("id"));
            objectifType.setType(rs.getString("type"));
            objectifType.setName(rs.getString("name"));
            objectifType.setDescription(rs.getString("description"));
            return objectifType;
        }
    }

    public List< ObjectifType > findAll() {
        return jdbcTemplate.query("select * from Objectiftypes", new ObjectifTypeRepository.ObjectifTypeRowMapper());
    }

    public Optional< ObjectifType > findById(long id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from Objectiftypes where id=?", new Object[] {
                        id
                },
                new BeanPropertyRowMapper< ObjectifType >(ObjectifType.class)));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from Objectiftypes where id=?", new Object[] {
                id
        });
    }

    public int insert(ObjectifType objectifType) {
        return jdbcTemplate.update("insert into Objectiftypes (id, type, name, description) " + "values(?, ?, ?, ?)",
                new Object[] {
                        objectifType.getId(), objectifType.getType(), objectifType.getName(), objectifType.getDescription()
                });
    }

    public int update(ObjectifType objectifType) {
        return jdbcTemplate.update("update Objectiftypes " + " set type = ?, name = ?, description = ? " + " where id = ?",
                new Object[] {
                        objectifType.getType(), objectifType.getName(), objectifType.getDescription(), objectifType.getId()
                });
    }
}
