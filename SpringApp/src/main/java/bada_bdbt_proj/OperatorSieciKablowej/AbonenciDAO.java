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
public class AbonenciDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AbonenciDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Abonent> list(){
        String sql = "SELECT * FROM \"Abonenci\"";
        List<Abonent> listAbonent = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Abonent.class));
        return listAbonent;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
//    @RolesAllowed("ADMIN")
    public void save(Abonent abonent) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("\"Abonenci\"").usingColumns("\"Adres_email\"", "\"Numer_telefonu\"", "\"ID_operatora\"", "\"Nr_adresu\"");
        Map<String, String> mapa = new HashMap<>();
//        mapa.put("\"ID_abonenta\"", Integer.toString(abonent.getIdAbonenta()));
        mapa.put("\"Adres_email\"", abonent.getAdresEmail());
        mapa.put("\"Numer_telefonu\"", abonent.getNumerTelefonu());
        mapa.put("\"ID_operatora\"", Integer.toString(abonent.getIdOperatora()));
        mapa.put("\"Nr_adresu\"", Integer.toString(abonent.getNrAdresu()));
        insertActor.execute(mapa);
    }
    /* Read – odczytywanie danych z bazy */
//    @RolesAllowed("ADMIN")
    public Abonent get(int idAbonenta){
        Object[] args = {idAbonenta};
        String sql = "SELECT * FROM \"Abonenci\" WHERE \"ID_abonenta\" = " + args[0];
        Abonent abonent = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Abonent.class));
        return abonent;
    }
    public Abonent get(String login){
        Object[] args = {login};
        String sql = "SELECT * FROM \"Abonenci\" WHERE \"Adres_email\" = " +"'" + args[0] +"'";
        Abonent abonent = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Abonent.class));
        return abonent;
    }
    /* Update – aktualizacja danych */
//    @RolesAllowed("ADMIN")
    public void update(Abonent abonent) {

        String sql = "UPDATE \"Abonenci\" SET \"Adres_email\"=:adresEmail, \"Numer_telefonu\"=:numerTelefonu, \"ID_operatora\"=:idOperatora, \"Nr_adresu\"=:nrAdresu WHERE \"ID_abonenta\"=:idAbonenta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(abonent);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
//    @RolesAllowed("ADMIN")
    public void delete(int idAbonenta) {
        String sql = "DELETE FROM \"Abonenci\" WHERE \"ID_abonenta\" =?";
        jdbcTemplate.update(sql, idAbonenta);

    }

}
