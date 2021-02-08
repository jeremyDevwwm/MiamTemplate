package com.projet.titre.cecile.TitreDev.Security;


import com.projet.titre.cecile.TitreDev.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

/**
 * Fichier de configuration de spring web security
 * il va traiter de l'authentification et de la manière dont seront traitées les requêtes
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Autoconstruction de l'objet UserService
     */
    @Autowired
    private UserService userDetailsService;

    /**
     * Gestion de l'authentification en passant par l'outil AuthenticationManagerBuilder
     * @param auth paramètre de type AuthenticationManagerBuilder
     * @throws Exception si l'autentification ne fonctionne pas
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    /**
     * Gestion du trigger de web security par rapport aux chemins de l'API, à changer.
     * @param http paramètre de type HttpSecurity
     * @throws Exception si les requêtes n'aboutissent à rien
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/")
                .authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/Accueil.html", true);

        http.csrf().disable();
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
        http.sessionManagement().maximumSessions(2).expiredUrl("/login?expired");

        http
                .logout(logout -> logout
                        .logoutUrl("/Logout")
                        .addLogoutHandler(new SecurityContextLogoutHandler())
                );
    }

    /**
     * Bean permettant l'encodage de password
     * @return l'encodeur de password
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
