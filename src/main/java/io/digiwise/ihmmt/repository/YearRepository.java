package io.digiwise.ihmmt.repository;

import io.digiwise.ihmmt.model.Year;
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
public class YearRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class YearRowMapper implements RowMapper<Year> {
        @Override
        public Year mapRow(ResultSet rs, int rowNum) throws SQLException {
            Year year = new Year();
            year.setId(rs.getLong("id"));
            year.setName(rs.getString("name"));
            year.setDescription(rs.getString("description"));
            return year;
        }
    }

    public List< Year > findAll() {
        return jdbcTemplate.query("select * from Years", new YearRepository.YearRowMapper());
    }

    public Optional< Year > findById(long id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from Years where id=?", new Object[] {
                        id
                },
                new BeanPropertyRowMapper< Year >(Year.class)));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from Years where id=?", new Object[] {
                id
        });
    }

    public int insert(Year year) {
        return jdbcTemplate.update("insert into Years (id, name, description) " + "values(?, ?, ?)",
                new Object[] {
                        year.getId(), year.getName(), year.getDescription()
                });
    }

    public int update(Year year) {
        return jdbcTemplate.update("update Years " + " set name = ?, description = ? " + " where id = ?",
                new Object[] {
                        year.getName(), year.getDescription(), year.getId()
                });
    }
}
