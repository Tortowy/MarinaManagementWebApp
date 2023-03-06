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

public class AdresyDAOTest {

    private AdresyDAO dao;

    @BeforeEach
    void setUp(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        dataSource.setUsername("badagrb12");
        dataSource.setPassword("BADAGRB12");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new AdresyDAO(new JdbcTemplate(dataSource));

    }

    @Test
    void testList(){

        List<Adresy> listAdresy = dao.list();
        assertFalse(listAdresy.isEmpty());

    }

    @Test
    void testSave(){
        Adresy adresy = new Adresy(999,"Poznan","Krutka",12,62);
        dao.save(adresy);

    }

    @Test
    void testGet(){
        int nrAdresu = 3;
        Adresy adresy = dao.get(nrAdresu);

        assertNotNull(adresy);

    }

    @Test
    void testUpdate() {
        Adresy adresy= new Adresy();
        adresy.setNrAdresu(21);
        adresy.setMiasto("testowo111");
        adresy.setUlica("ulicaTestowa");
        adresy.setNrDomu(666);
        adresy.setNrPoczty(62);

        dao.update(adresy);
    }

    @Test
    void testDelete(){
        int nrAdresu = 21;
        dao.delete(nrAdresu);

    }

}
