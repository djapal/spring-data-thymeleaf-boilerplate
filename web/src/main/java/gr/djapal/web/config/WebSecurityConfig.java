package gr.djapal.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
      authManagerBuilder.inMemoryAuthentication().withUser("admin").password("admin123").roles("ADMIN");
      authManagerBuilder.inMemoryAuthentication().withUser("user").password("user123").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/resources*//**").permitAll()
            .antMatchers("/admin*//**//**").access("hasRole('ADMIN')")
            .antMatchers("/welcome").access("hasRole('ADMIN') or hasRole('USER')")
            .and()
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error")
            .defaultSuccessUrl("/welcome")
            .permitAll();
        //.and().exceptionHandling().authenticationEntryPoint(new AuthenticationProcessingFilterEntryPoint("/login"));
    }

}
