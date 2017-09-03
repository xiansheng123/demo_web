package com.example.demo_web.respository;

import com.example.demo_web.Entity.CarDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CarDBTemplateRespository {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate() ;

    public CarDB getCarById(int id){
        String sql = "select * from sec_cars where id=?";
       // RowMapper<CarDB> rowMapper = new BeanPropertyRowMapper<CarDB>(CarDB.class);
        return jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            return new CarDB(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4));
            },id
        );
    }
}
