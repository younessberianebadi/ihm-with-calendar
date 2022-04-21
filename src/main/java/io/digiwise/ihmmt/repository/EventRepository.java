package io.digiwise.ihmmt.repository;

import io.digiwise.ihmmt.model.Event;
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
public class EventRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class EventRowMapper implements RowMapper<Event> {
        @Override
        public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
            Event event = new Event();
            event.setId(rs.getLong("id"));
            event.setTitle(rs.getString("title"));
            event.setDate(rs.getDate("date").toLocalDate());
            event.setDate2(rs.getDate("date2").toLocalDate());
            return event;
        }
    }

    public List< Event > findAll() {
        return jdbcTemplate.query("select * from EVENTS", new EventRowMapper());
    }

    public Optional< Event > findById(long id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from EVENTS where id=?", new Object[] {
                        id
                },
                new BeanPropertyRowMapper< Event >(Event.class)));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from EVENTS where id=?", new Object[] {
                id
        });
    }

    public int insert(Event event) {
        return jdbcTemplate.update("insert into events (id, title, date, date2) " + "values(?, ?, ?, ?)",
                new Object[] {
                        event.getId(), event.getTitle(), event.getDate(), event.getDate2()
                });
    }

    public int update(Event event) {
        return jdbcTemplate.update("update events " + " set title = ?, date = ?, date2 = ? " + " where id = ?",
                new Object[] {
                        event.getTitle(), event.getDate(), event.getDate2(), event.getId()
                });
    }
}
