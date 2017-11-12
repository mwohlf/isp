package net.wohlfart.isp.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan({"net.wohlfart"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // @formatter:off
        httpSecurity     // implements HttpsSecurityBuilder
                .csrf().disable() // We don't need CSRF for JWT based authentication
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()  // returns the SecurityBuilder
                .authorizeRequests()
                    .antMatchers("/", "/login", "/logout", "/about").permitAll() // sign in end-point allowed by anyone
            ;
    }

}
