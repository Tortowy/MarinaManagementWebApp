package MSJW_BADA_Project.StringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MarinyDAO {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public MarinyDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Mariny> list(){
        String sql = "SELECT * FROM mariny";
        List<Mariny> listMariny = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Mariny.class));
        return listMariny;
    }

}
