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
public class PocztyDAO {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public PocztyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Poczty> list(){
        String sql = "SELECT * FROM poczty";
        List<Poczty> listPoczty = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Poczty.class));
        return listPoczty;
    }

    public void save(Poczty poczty){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("poczty").usingColumns("kod_poczty","miejscowosc_poczty");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczty);
        insertActor.execute(param);
    }

    public Poczty get(int nrPoczty){
        String sql = "SELECT * FROM poczty WHERE NR_Poczty = ?";
        Object[] args = {nrPoczty};
        Poczty poczta = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Poczty.class));
        return poczta;
    }

    public Poczty get1(int nrPoczty){
        Object[] args = {nrPoczty};
        String sql = "SELECT * FROM poczty WHERE Nr_Poczty = " + args[0];
        Poczty poczta = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Poczty.class));
        return poczta;
    }


    public void update(Poczty poczty){
        String sql = "UPDATE poczty SET kod_poczty=:kodPoczty, miejscowosc_poczty=:miejscowoscPoczty WHERE Nr_Poczty=:nrPoczty";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczty);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nrPoczty){
        String sql = "DELETE FROM poczty WHERE Nr_Poczty = ? ";
        jdbcTemplate.update(sql,nrPoczty);

    }
}
