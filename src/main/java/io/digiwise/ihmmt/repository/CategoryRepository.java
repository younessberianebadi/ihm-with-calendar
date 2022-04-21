package io.digiwise.ihmmt.repository;

import io.digiwise.ihmmt.model.CG;
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
public class CategoryRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class CategoryRowMapper implements RowMapper<CG> {
        @Override
        public CG mapRow(ResultSet rs, int rowNum) throws SQLException {
            CG CG = new CG();
            CG.setId(rs.getLong("id"));
            CG.setName(rs.getString("name"));
            CG.setDescription(rs.getString("description"));
//            category.setProducts(rs.getArray("products"));
            return CG;
        }
    }

    public List<CG> findAll() {
        return jdbcTemplate.query("select * from Categories", new CategoryRepository.CategoryRowMapper());
    }

    public Optional<CG> findById(long id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from Categories where id=?", new Object[] {
                        id
                },
                new BeanPropertyRowMapper<CG>(CG.class)));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from Categories where id=?", new Object[] {
                id
        });
    }

    public int insert(CG CG) {
        return jdbcTemplate.update("insert into Categories (id, name, description) " + "values(?, ?, ?)",
                new Object[] {
                        CG.getId(), CG.getName(), CG.getDescription()
                });
    }

    public int update(CG CG) {
        return jdbcTemplate.update("update Categories " + " set name = ?, description = ? " + " where id = ?",
                new Object[] {
                        CG.getName(), CG.getDescription(), CG.getId()
                });
    }
}
