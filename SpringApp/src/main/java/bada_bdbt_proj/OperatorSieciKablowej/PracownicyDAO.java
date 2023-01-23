package bada_bdbt_proj.OperatorSieciKablowej;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;

import javax.annotation.security.RolesAllowed;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PracownicyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List  (zawiera info z bazy danych) */
    public List<Pracownik> list(){
        String sql = "SELECT * FROM \"Pracownicy\"";
        List<Pracownik> listPracownik = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
        return listPracownik;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    @RolesAllowed("ADMIN")
    public void save(Pracownik pracownik) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("\"Pracownicy\"").usingColumns("\"Imie\"", "\"Nazwisko\"", "\"PESEL\"", "\"ID_operatora\"", "\"ID_lokalu\"");
        Map<String, String> mapa = new HashMap<>();
        mapa.put("\"Imie\"", pracownik.getImie());
        mapa.put("\"Nazwisko\"", pracownik.getNazwisko());
        mapa.put("\"PESEL\"", pracownik.getPesel());
        mapa.put("\"ID_operatora\"", Integer.toString(pracownik.getIdOperatora()));
        mapa.put("\"ID_lokalu\"", Integer.toString(pracownik.getIdLokalu()));
        insertActor.execute(mapa);
    }
    /* Read – odczytywanie danych z bazy */
    @RolesAllowed("ADMIN")
    public Pracownik get(int idPracownika){
        Object[] args = {idPracownika};
        String sql = "SELECT * FROM \"Pracownicy\" WHERE \"ID_pracownika\" = " + args[0];
        Pracownik pracownik = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
        return pracownik;
    }
    /* Update – aktualizacja danych */
    @RolesAllowed("ADMIN")
    public void update(Pracownik pracownik) {

        String sql = "UPDATE \"Pracownicy\" SET \"Imie\"=:imie, \"Nazwisko\"=:nazwisko, \"PESEL\"=:pesel, \"ID_operatora\"=:idOperatora, \"ID_lokalu\"=:idLokalu WHERE \"ID_pracownika\"=:idPracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    @RolesAllowed("ADMIN")
    public void delete(int idPracownika) {
        String sql = "DELETE FROM \"Pracownicy\" WHERE \"ID_pracownika\" =?";
        jdbcTemplate.update(sql, idPracownika);

    }

}
