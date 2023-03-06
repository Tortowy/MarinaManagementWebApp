package MSJW_BADA_Project.StringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PocztyDAOTest {

    private PocztyDAO dao;

    @BeforeEach
    void setUp(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        dataSource.setUsername("badagrb12");
        dataSource.setPassword("BADAGRB12");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new PocztyDAO(new JdbcTemplate(dataSource));

    }

    @Test
    void testList(){

        List<Poczty> listPoczty = dao.list();
        assertFalse(listPoczty.isEmpty());

    }

    @Test
    void testSave(){
        Poczty poczty = new Poczty(111111,"12411","Minsk");
        dao.save(poczty);

    }

    @Test
    void testGet(){
        int nrPoczty = 43;
        Poczty poczta = dao.get(nrPoczty);

        assertNotNull(poczta);

    }

    @Test
    void testUpdate() {
        Poczty poczty = new Poczty();
        poczty.setNrPoczty(43);
        poczty.setMiejscowoscPoczty("testowo111");
        poczty.setKodPoczty("333");

        dao.update(poczty);
    }

    @Test
    void testDelete(){
        int nrPoczty = 42;
        dao.delete(nrPoczty);

    }

}
