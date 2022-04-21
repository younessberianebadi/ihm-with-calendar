package io.digiwise.ihmmt.repository;

import io.digiwise.ihmmt.model.Event;
import io.digiwise.ihmmt.model.Objectif;
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
public class ObjectifRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class ObjectifRowMapper implements RowMapper<Objectif> {
        @Override
        public Objectif mapRow(ResultSet rs, int rowNum) throws SQLException {
            Objectif objectif = new Objectif();
            objectif.setId(rs.getLong("id"));
            objectif.setYear(rs.getString("year"));
            objectif.setCategory(rs.getString("category"));
            objectif.setProduct(rs.getString("product"));
            objectif.setObjectif(rs.getString("objectif"));
            objectif.setLevel(rs.getString("level"));
            objectif.setEntity(rs.getString("entity"));
            objectif.setJanuary(rs.getLong("january"));
            objectif.setFebruary(rs.getLong("february"));
            objectif.setMarch(rs.getLong("march"));
            objectif.setApril(rs.getLong("april"));
            objectif.setMay(rs.getLong("may"));
            objectif.setJune(rs.getLong("june"));
            objectif.setJuly(rs.getLong("july"));
            objectif.setAugust(rs.getLong("august"));
            objectif.setSeptember(rs.getLong("september"));
            objectif.setOctober(rs.getLong("october"));
            objectif.setNovember(rs.getLong("november"));
            objectif.setDecember(rs.getLong("december"));
            objectif.setTotal(rs.getLong("total"));
            objectif.setCreatedAt(rs.getDate("createdAt"));
            objectif.setCreatedBy(rs.getString("createdBy"));
            objectif.setUpdatedBy(rs.getString("updatedby"));
            objectif.setUpdatedAt(rs.getDate("updatedat"));
            return objectif;
        }
    }

    public List< Objectif > findAll() {
        return jdbcTemplate.query("select * from Objectifs", new ObjectifRepository.ObjectifRowMapper());
    }

    public Optional< Objectif > findById(long id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from Objectifs where id=?", new Object[] {
                        id
                },
                new BeanPropertyRowMapper< Objectif >(Objectif.class)));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from Objectifs where id=?", new Object[] {
                id
        });
    }

    public int insert(Objectif objectif) {
        return jdbcTemplate.update("insert into Objectifs (id, year, category, product, objectif, level, entity, january, february, march, april, may, june, july, august, september, october, november, december, total, createdat, updatedat, createdby, updatedby) " + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new Object[] {
                        objectif.getId(), objectif.getYear(), objectif.getCategory(), objectif.getProduct(), objectif.getObjectif(), objectif.getLevel(), objectif.getEntity(), objectif.getJanuary(), objectif.getFebruary(), objectif.getMarch(), objectif.getApril(), objectif.getMay(), objectif.getJune(), objectif.getJuly(), objectif.getAugust(), objectif.getSeptember(), objectif.getOctober(), objectif.getNovember(), objectif.getDecember(), objectif.getTotal(), objectif.getCreatedAt(), objectif.getUpdatedAt(), objectif.getCreatedBy(), objectif.getUpdatedBy()
                });
    }

    public int update(Objectif objectif) {
        return jdbcTemplate.update("update Objectifs " + " set year = ?, category = ?, product = ?, objectif = ?, level = ?, entity = ?, january = ?, february = ?, march = ?, april = ?, may = ?, june = ?, july = ?, august = ?, september = ?, october = ?, november = ?, december = ?, total = ?, createdat = ?, updatedat = ?, createdby = ?, updatedby = ? " + " where id = ?",
                new Object[] {
                        objectif.getYear(), objectif.getCategory(), objectif.getProduct(), objectif.getObjectif(), objectif.getLevel(), objectif.getEntity(), objectif.getJanuary(), objectif.getFebruary(), objectif.getMarch(), objectif.getApril(), objectif.getMay(), objectif.getJune(), objectif.getJuly(), objectif.getAugust(), objectif.getSeptember(), objectif.getOctober(), objectif.getNovember(), objectif.getDecember(), objectif.getCreatedAt(), objectif.getUpdatedAt(), objectif.getCreatedBy(), objectif.getUpdatedBy(), objectif.getId()
                });
    }
}
