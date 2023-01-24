package bada_bdbt_proj.OperatorSieciKablowej;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT \"Adres_email\", \"ID_abonenta\", \"ENABLED\"" +
                        "FROM \"Abonenci\"" +
                        "WHERE \"Adres_email\"=?")
                .authoritiesByUsernameQuery("SELECT \"Adres_email\", \"ROLA\"" +
                        "FROM \"Abonenci\""+
                        "WHERE \"Adres_email\"=?");
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");
    }
    @Bean
    public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/resources/static/**").permitAll()
                .antMatchers("/main").authenticated()
                .antMatchers("/main_admin").access("hasRole('ADMIN')")
                .antMatchers("/main_user").access("hasRole('USER')")
                .antMatchers("/pracownicy" ).access("hasRole('ADMIN')")
                .antMatchers("/nowy_pracownik" ).access("hasRole('ADMIN')")
                .antMatchers("/edytuj_dane_pracownika" ).access("hasRole('ADMIN')")
                .antMatchers("/abonenci" ).access("hasRole('ADMIN')")
                .antMatchers("/nowy_abonent" ).access("hasRole('ADMIN')")
                .antMatchers("/edytuj_dane_aboneneta" ).access("hasRole('ADMIN')")
                .antMatchers("/adresy" ).access("hasRole('ADMIN')")
                .antMatchers("/nowy_adres" ).access("hasRole('ADMIN')")
                .antMatchers("/edytuj_dane_adresu" ).access("hasRole('ADMIN')")
                .antMatchers("/lokale" ).access("hasRole('ADMIN')")
                .antMatchers("/nowy_lokal" ).access("hasRole('ADMIN')")
                .antMatchers("/edytuj_dane_lokalu" ).access("hasRole('ADMIN')")
                .antMatchers("/poczty" ).access("hasRole('ADMIN')")
                .antMatchers("/nowa_poczta" ).access("hasRole('ADMIN')")
                .antMatchers("/edytuj_dane_poczty" ).access("hasRole('ADMIN')")
                .antMatchers("/pracownicy" ).access("hasRole('ADMIN')")
                .antMatchers("/nowy_pracownik" ).access("hasRole('ADMIN')")
                .antMatchers("/save").authenticated()
                .antMatchers("/edytuj_dane_pracownika" ).access("hasRole('ADMIN')")
                .antMatchers("/uslugi" ).access("hasRole('ADMIN')")
                .antMatchers("/nowa_usluga" ).access("hasRole('ADMIN')")
                .antMatchers("/edytuj_dane_uslugi" ).access("hasRole('ADMIN')")
                .antMatchers("/uslugi_u").access("hasRole('USER')")
                .antMatchers("/twoj_profil").access("hasRole('USER')")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/index")
                .logoutSuccessUrl("/index")
                .permitAll();
    }
}