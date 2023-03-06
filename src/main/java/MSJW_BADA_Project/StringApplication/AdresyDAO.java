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
public class AdresyDAO {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public AdresyDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adresy> list(){
        String sql = "SELECT * FROM adresy";
        List<Adresy> listAdresy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
        return listAdresy;
    }

    public void save(Adresy adresy){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("adresy").usingColumns("miasto","ulica","nr_domu","nr_poczty");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
        insertActor.execute(param);
    }

    public Adresy get(int nrAdresy){
        String sql = "SELECT * FROM adresy WHERE NR_ADRESU = ?";
        Object[] args = {nrAdresy};
        Adresy adresy = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Adresy.class));
        return adresy;
    }

    public void update(Adresy adresy){
        String sql = "UPDATE adresy SET miasto=:miasto, ulica=:ulica, nr_domu=:nrDomu, nr_poczty=:nrPoczty WHERE nr_adresu=:nrAdresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }


    public List<Adresy> getAdresyOfClients(){
        String sql = "SELECT * FROM adresy WHERE nr_adresu IN(SELECT nr_adresu FROM klienci) OR nr_adresu NOT IN(SELECT nr_adresu FROM pracownicy) AND nr_adresu NOT IN(SELECT nr_adresu FROM mariny)";
        List<Adresy> listAdresy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
        return listAdresy;
    }


    public void delete(int nrAdresu){
        String sql = "DELETE FROM adresy WHERE Nr_Adresu = ? ";
        jdbcTemplate.update(sql,nrAdresu);

    }

}
