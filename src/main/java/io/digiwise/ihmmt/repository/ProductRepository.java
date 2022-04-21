package io.digiwise.ihmmt.repository;

import io.digiwise.ihmmt.model.Product;
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
public class ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("name"));
            product.setDescription(rs.getString("description"));
            product.setCategoryId(rs.getLong("categoryid"));
            return product;
        }
    }

    public List< Product > findAll() {
        return jdbcTemplate.query("select * from Products", new ProductRepository.ProductRowMapper());
    }

    public Optional< Product > findById(long id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from Products where id=?", new Object[] {
                        id
                },
                new BeanPropertyRowMapper< Product >(Product.class)));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from Products where id=?", new Object[] {
                id
        });
    }

    public int insert(Product product) {
        return jdbcTemplate.update("insert into Products (id, name, description, categoryid) " + "values(?, ?, ?, ?)",
                new Object[] {
                        product.getId(), product.getName(), product.getDescription(), product.getCategoryId()
                });
    }

    public int update(Product product) {
        return jdbcTemplate.update("update Products " + " set name = ?, description = ?, categoryid = ? " + " where id = ?",
                new Object[] {
                        product.getName(), product.getDescription(), product.getCategoryId(), product.getId()
                });
    }
}
