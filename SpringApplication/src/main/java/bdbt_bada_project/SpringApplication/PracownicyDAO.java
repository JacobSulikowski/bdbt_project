package bdbt_bada_project.SpringApplication;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
public class PracownicyDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Pracownicy> list(){
        String sql = "SELECT * FROM \"Pracownicy\"";

        List<Pracownicy> listPracownicy = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return listPracownicy;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Pracownicy pracownicy) {
    }
    /* Read – odczytywanie danych z bazy */
    public Pracownicy get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Pracownicy pracownicy) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
