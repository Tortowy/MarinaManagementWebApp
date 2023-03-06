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

public class StanowiskaDAOTest {

    private StanowiskaDAO dao;

    @BeforeEach
    void setUp(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        dataSource.setUsername("badagrb12");
        dataSource.setPassword("BADAGRB12");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new StanowiskaDAO(new JdbcTemplate(dataSource));

    }

    @Test
    void testList(){

        List<Stanowiska> listStanowiska = dao.list();
        assertFalse(listStanowiska.isEmpty());

    }

    @Test
    void testSave(){
        Stanowiska stanowiska = new Stanowiska(12,"murasz","murasz muruje",10);
        dao.save(stanowiska);

    }

    @Test
    void testGet(){
        int nrStanowiska = 21;
        Stanowiska stanowiska= dao.get(nrStanowiska);

        assertNotNull(stanowiska);

    }

    @Test
    void testUpdate() {
        Stanowiska stanowiska = new Stanowiska();
        stanowiska.setNrStanowiska(21);
        stanowiska.setNazwaStanowiska("murasz");
        stanowiska.setOpisStanowiska("murasz nic nie robi");
        stanowiska.setPensjaBazowa(100000);

        dao.update(stanowiska);
    }

    @Test
    void testDelete(){
        int nrStanowiska = 21;
        dao.delete(nrStanowiska);

    }

}
