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
public class KlienciDAO {


    private JdbcTemplate jdbcTemplate;
    @Autowired
    public KlienciDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klienci> list(){
        String sql = "SELECT * FROM klienci";
        List<Klienci> listKlienci = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klienci.class));
        return listKlienci;
    }

    public void save(Klienci klienci){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("klienci").usingColumns("imie","nazwisko","nr_telefonu","pesel",
                "data_urodzenia","plec","nr_ubezpieczenia","nr_mariny","nr_adresu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klienci);
        insertActor.execute(param);
    }

    public Klienci get(int nrKlienta){
        String sql = "SELECT * FROM klienci WHERE NR_KLIENTA = ?";
        Object[] args = {nrKlienta};
        Klienci klienci = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Klienci.class));
        return klienci;
    }


    public void update(Klienci klienci){
        String sql = "UPDATE klienci SET imie=:imie, nazwisko=:nazwisko," +
                " nr_telefonu=:nrTelefonu,pesel=:pesel,data_urodzenia=:dataUrodzenia,plec=:plec," +
                "nr_ubezpieczenia=:nrUbezpieczenia,nr_mariny=:nrMariny,nr_adresu=:nrAdresu WHERE nr_klienta=:nrKlienta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klienci);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nrKlienta){
        String sql = "DELETE FROM klienci WHERE nr_klienta = ? ";
        jdbcTemplate.update(sql,nrKlienta);

    }



}
