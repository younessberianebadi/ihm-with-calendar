package io.digiwise.ihmmt.repository;


import io.digiwise.ihmmt.model.Entity;
import io.digiwise.ihmmt.model.Month;
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
public class EntityRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class EntityRowMapper implements RowMapper<Entity> {
        @Override
        public Entity mapRow(ResultSet rs, int rowNum) throws SQLException {
            Entity entity = new Entity();
            entity.setId(rs.getLong("id"));
            entity.setName(rs.getString("name"));
            entity.setLevel(rs.getString("level"));
            entity.setIdDirector(rs.getLong("idParent"));
            entity.setIdDirector(rs.getLong("idDirector"));
            return entity;
        }
    }

    public List< Entity > findAll() {
        return jdbcTemplate.query("select * from Entities", new EntityRepository.EntityRowMapper());
    }

    public Optional< Entity > findById(long id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from Entities where id=?", new Object[] {
                        id
                },
                new BeanPropertyRowMapper< Entity >(Entity.class)));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from Entities where id=?", new Object[] {
                id
        });
    }

    public int insert(Entity entity) {
        return jdbcTemplate.update("insert into Entities (id, name, level, idParent, idDirector) " + "values(?, ?, ?, ?, ?)",
                new Object[] {
                        entity.getId(), entity.getName(), entity.getLevel(), entity.getIdParent(), entity.getIdDirector()
                });
    }

    public int update(Entity entity) {
        return jdbcTemplate.update("update Entities " + " set name = ?, level = ?, idParent = ?, idDirector = ?" + " where id = ?",
                new Object[] {
                        entity.getName(), entity.getLevel(), entity.getIdParent(), entity.getIdDirector(), entity.getId()
                });
    }
}
