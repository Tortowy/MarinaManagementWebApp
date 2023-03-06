package MSJW_BADA_Project.StringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDAOTest {

    private PracownicyDAO dao;

    @BeforeEach
    void setUp(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        dataSource.setUsername("badagrb12");
        dataSource.setPassword("BADAGRB12");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new PracownicyDAO(new JdbcTemplate(dataSource));

    }

    @Test
    void testList(){

        List<Pracownicy> listPracownicy = dao.list();
        assertFalse(listPracownicy.isEmpty());

    }

    @Test
    void testSave(){
        Pracownicy pracownicy = new Pracownicy(99,"Krzysztof","Gierek","21313423123",
                "M","666331133",new Date(2002,12,12),"123456789","1212",4,22,2);
        dao.save(pracownicy);

    }

    @Test
    void testGet(){
        int nrPracownika = 21;
        Pracownicy pracownicy = dao.get(nrPracownika);

        assertNotNull(pracownicy);

    }

    @Test
    void testUpdate() {
        Pracownicy pracownicy = new Pracownicy();
        pracownicy.setNrPracownika(21);
        pracownicy.setImie("JACEK");
        pracownicy.setNazwisko("Obszczymurek");
        pracownicy.setPesel("987654321");
        pracownicy.setPlec("K");
        pracownicy.setNrTelefonu("123346789");
        pracownicy.setDataZatrudnienia(new Date(2002,12,12));
        pracownicy.setNrPrawaJazdy("123456789");
        pracownicy.setPensjaDodatkowa("2121");
        pracownicy.setNrMariny(4);
        pracownicy.setNrAdresu(22);
        pracownicy.setNrStanowiska(2);


        dao.update(pracownicy);
    }

    @Test
    void testDelete(){
        int nrStanowiska = 21;
        dao.delete(nrStanowiska);

    }

}
