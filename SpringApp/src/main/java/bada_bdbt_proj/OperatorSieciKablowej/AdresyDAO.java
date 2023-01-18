package bada_bdbt_proj.OperatorSieciKablowej;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AdresyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdresyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Adres> list(){
        String sql = "SELECT * FROM \"Adresy\"";
        List<Adres> listAdresy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
        return listAdresy;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    @Secured("ADMIN")
    public void save(Adres adres) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("\"Adresy\"").usingColumns("\"Nr_adresu\"", "\"Nazwa_ulicy\"", "\"Nr_budynku\"", "\"Nr_lokalu\"", "\"Miasto\"", "\"Nr_poczty\"");
        Map<String, String> mapa = new HashMap<>();
        mapa.put("\"Nr_adresu\"", Integer.toString(adres.getNrAdresu()));
        mapa.put("\"Nazwa_ulicy\"", adres.getNazwaUlicy());
        mapa.put("\"Nr_budynku\"", adres.getNrBudynku());
        mapa.put("\"Nr_lokalu\"", adres.getNrLokalu());
        mapa.put("\"Miasto\"", adres.getMiasto());
        mapa.put("\"Nr_poczty\"", Integer.toString(adres.getNrPoczty()));
        insertActor.execute(mapa);
    }
    /* Read – odczytywanie danych z bazy */
    @Secured("ADMIN")
    public Adres get(int nrAdresu){
        Object[] args = {nrAdresu};
        String sql = "SELECT * FROM \"Adresy\" WHERE \"Nr_adresu\" = " + args[0];
        Adres adres = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adres.class));
        return adres;
    }
    /* Update – aktualizacja danych */
    @Secured("ADMIN")
    public void update(Adres adres) {

        String sql = "UPDATE \"Adresy\" SET \"Nazwa_ulicy\"=:nazwaUlicy, \"Nr_budynku\"=:nrBudynku, \"Nr_lokalu\"=:nrLokalu, \"Miasto\"=:miasto, \"Nr_poczty\"=:nrPoczty WHERE \"Nr_adresu\"=:nrAdresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    @Secured("ADMIN")
    public void delete(int nrAdresu) {
        String sql = "DELETE FROM \"Adresy\" WHERE \"Nr_adresu\" =?";
        jdbcTemplate.update(sql, nrAdresu);

    }
}
