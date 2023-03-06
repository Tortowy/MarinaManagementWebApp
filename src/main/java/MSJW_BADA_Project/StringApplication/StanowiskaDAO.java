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
public class StanowiskaDAO {


    private JdbcTemplate jdbcTemplate;
    @Autowired
    public StanowiskaDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Stanowiska> list(){
        String sql = "SELECT * FROM stanowiska";
        List<Stanowiska> listStanowiska = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Stanowiska.class));
        return listStanowiska;
    }

    public void save(Stanowiska stanowiska){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("stanowiska").usingColumns("nazwa_stanowiska","opis_stanowiska","pensja_bazowa");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(stanowiska);
        insertActor.execute(param);
    }

    public Stanowiska get(int nrStanowiska){
        String sql = "SELECT * FROM stanowiska WHERE NR_STANOWISKA = ?";
        Object[] args = {nrStanowiska};
        Stanowiska stanowiska = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Stanowiska.class));
        return stanowiska;
    }

    public void update(Stanowiska stanowiska){
        String sql = "UPDATE stanowiska SET nazwa_stanowiska=:nazwaStanowiska, opis_stanowiska=:opisStanowiska, pensja_bazowa=:pensjaBazowa WHERE nr_stanowiska=:nrStanowiska";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(stanowiska);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nrStanowiska){
        String sql = "DELETE FROM stanowiska WHERE nr_stanowiska = ? ";
        jdbcTemplate.update(sql,nrStanowiska);

    }


}
