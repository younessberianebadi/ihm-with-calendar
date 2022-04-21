package io.digiwise.ihmmt.repository;

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
public class MonthRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class MonthRowMapper implements RowMapper<Month> {
        @Override
        public Month mapRow(ResultSet rs, int rowNum) throws SQLException {
            Month month = new Month();
            month.setId(rs.getLong("id"));
            month.setName(rs.getString("name"));
            month.setDescription(rs.getString("description"));
            return month;
        }
    }

    public List< Month > findAll() {
        return jdbcTemplate.query("select * from Months", new MonthRepository.MonthRowMapper());
    }

    public Optional< Month > findById(long id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from Months where id=?", new Object[] {
                        id
                },
                new BeanPropertyRowMapper< Month >(Month.class)));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from Months where id=?", new Object[] {
                id
        });
    }

    public int insert(Month month) {
        return jdbcTemplate.update("insert into Months (id, name, description) " + "values(?, ?, ?)",
                new Object[] {
                        month.getId(), month.getName(), month.getDescription()
                });
    }

    public int update(Month month) {
        return jdbcTemplate.update("update Months " + " set name = ?, description = ? " + " where id = ?",
                new Object[] {
                        month.getName(), month.getDescription(), month.getId()
                });
    }
}
