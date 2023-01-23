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
public class LokaleDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public LokaleDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Lokal> list(){
        String sql = "SELECT * FROM \"Lokale\"";
        List<Lokal> listLokal = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Lokal.class));
        return listLokal;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    @RolesAllowed("ADMIN")
    public void save(Lokal lokal) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("\"Lokale\"").usingColumns("\"ID_lokalu\"", "\"ID_operatora\"", "\"Nr_adresu\"");
        Map<String, String> mapa = new HashMap<>();
        mapa.put("\"ID_lokalu\"", Integer.toString(lokal.getIdLokalu()));
        mapa.put("\"ID_operatora\"", Integer.toString(lokal.getIdOperatora()));
        mapa.put("\"Nr_adresu\"", Integer.toString(lokal.getNrAdresu()));
        insertActor.execute(mapa);
    }
    /* Read – odczytywanie danych z bazy */
    @RolesAllowed("ADMIN")
    public Lokal get(int nrLokalu){
        Object[] args = {nrLokalu};
        String sql = "SELECT * FROM \"Lokale\" WHERE \"ID_lokalu\" = " + args[0];
        Lokal lokal = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Lokal.class));
        return lokal;
    }
    /* Update – aktualizacja danych */
    @RolesAllowed("ADMIN")
    public void update(Lokal lokal) {

        String sql = "UPDATE \"Lokale\" SET \"ID_operatora\"=:idOperatora, \"Nr_adresu\"=:nrAdresu WHERE \"ID_lokalu\"=:idLokalu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(lokal);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    @RolesAllowed("ADMIN")
    public void delete(int nrLokalu) {
        String sql = "DELETE FROM \"Lokale\" WHERE \"ID_lokalu\" =?";
        jdbcTemplate.update(sql, nrLokalu);

    }
}
