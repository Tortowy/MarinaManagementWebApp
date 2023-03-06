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
public class PracownicyDAO {


    private JdbcTemplate jdbcTemplate;
    @Autowired
    public PracownicyDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pracownicy> list(){
        String sql = "SELECT * FROM pracownicy";
        List<Pracownicy> listPracownicy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return listPracownicy;
    }

    public void save(Pracownicy pracownicy){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pracownicy").usingColumns("imie","nazwisko","pesel","plec",
                "nr_telefonu","data_zatrudnienia","nr_prawa_jazdy","pensja_dodatkowa","nr_mariny","nr_adresu","nr_stanowiska");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        insertActor.execute(param);
    }

    public Pracownicy get(int nrPracownika){
        String sql = "SELECT * FROM pracownicy WHERE NR_PRACOWNIKA = ?";
        Object[] args = {nrPracownika};
        Pracownicy pracownicy = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return pracownicy;
    }

    public void update(Pracownicy pracownicy){
        String sql = "UPDATE pracownicy SET imie=:imie, nazwisko=:nazwisko," +
                " pesel=:pesel,plec=:plec,nr_telefonu=:nrTelefonu,data_zatrudnienia=:dataZatrudnienia,nr_prawa_jazdy=:nrPrawaJazdy," +
                "pensja_dodatkowa=:pensjaDodatkowa,nr_mariny=:nrMariny,nr_adresu=:nrAdresu,nr_stanowiska=:nrStanowiska WHERE nr_pracownika=:nrPracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nrPracownika){
        String sql = "DELETE FROM pracownicy WHERE nr_pracownika = ? ";
        jdbcTemplate.update(sql,nrPracownika);

    }


}
