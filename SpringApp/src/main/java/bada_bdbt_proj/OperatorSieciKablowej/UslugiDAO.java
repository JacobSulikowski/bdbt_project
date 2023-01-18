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
public class UslugiDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UslugiDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List  (zawiera info z bazy danych) */
    public List<Usluga> list(){
        String sql = "SELECT * FROM \"Uslugi\"";
        List<Usluga> listUsluga = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Usluga.class));
        return listUsluga;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    @Secured("ADMIN")
    public void save(Usluga usluga) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("\"Uslugi\"").usingColumns("\"ID_uslugi\"", "\"Nazwa\"", "\"Opis\"", "\"Cena\"", "\"ID_operatora\"");
        Map<String, String> mapa = new HashMap<>();
        mapa.put("\"ID_uslugi\"", Integer.toString(usluga.getIdUslugi()));
        mapa.put("\"Nazwa\"", usluga.getNazwa());
        mapa.put("\"Opis\"", usluga.getOpis());
        mapa.put("\"Cena\"", usluga.getCena());
        mapa.put("\"ID_operatora\"", Integer.toString(usluga.getIdOperatora()));
        insertActor.execute(mapa);
    }
    /* Read – odczytywanie danych z bazy */
    @Secured("ADMIN")
    public Usluga get(int idUslugi){
        Object[] args = {idUslugi};
        String sql = "SELECT * FROM \"Uslugi\" WHERE \"ID_uslugi\" = " + args[0];
        Usluga usluga = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Usluga.class));
        return usluga;
    }
    /* Update – aktualizacja danych */
    @Secured("ADMIN")
    public void update(Usluga usluga) {

        String sql = "UPDATE \"Uslugi\" SET \"Nazwa\"=:nazwa, \"Opis\"=:opis, \"Cena\"=:cena, \"ID_operatora\"=:idOperatora WHERE \"ID_uslugi\"=:idUslugi";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(usluga);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    @Secured("ADMIN")
    public void delete(int idUslugi) {
        String sql = "DELETE FROM \"Uslugi\" WHERE \"ID_uslugi\" =?";
        jdbcTemplate.update(sql, idUslugi);

    }
}
