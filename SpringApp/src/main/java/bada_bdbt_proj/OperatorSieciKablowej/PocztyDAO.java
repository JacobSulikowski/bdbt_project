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
public class PocztyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PocztyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Poczta> list(){
        String sql = "SELECT * FROM \"Poczty\"";
        List<Poczta> listPoczty = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Poczta.class));
        return listPoczty;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    @RolesAllowed("ADMIN")
    public void save(Poczta poczta) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("\"Poczty\"").usingColumns("\"Nr_poczty\"", "\"Kod_poczty\"", "\"Poczta\"");
        Map<String, String> mapa = new HashMap<>();
        mapa.put("\"Nr_poczty\"", Integer.toString(poczta.getNrPoczty()));
        mapa.put("\"Kod_poczty\"", poczta.getKodPoczty());
        mapa.put("\"Poczta\"", poczta.getPoczta());
        insertActor.execute(mapa);
    }
    /* Read – odczytywanie danych z bazy */
    @RolesAllowed("ADMIN")
    public Poczta get(int nrPoczty){
        Object[] args = {nrPoczty};
        String sql = "SELECT * FROM \"Poczty\" WHERE \"Nr_poczty\" = " + args[0];
        Poczta poczta = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Poczta.class));
        return poczta;
    }
    /* Update – aktualizacja danych */
    @RolesAllowed("ADMIN")
    public void update(Poczta poczta) {

        String sql = "UPDATE \"Poczty\" SET \"Kod_poczty\"=:kodPoczty, \"Poczta\"=:poczta WHERE \"Nr_poczty\"=:nrPoczty";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczta);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    @RolesAllowed("ADMIN")
    public void delete(int nrPoczty) {
        String sql = "DELETE FROM \"Poczty\" WHERE \"Nr_poczty\" =?";
        jdbcTemplate.update(sql, nrPoczty);

    }
}

