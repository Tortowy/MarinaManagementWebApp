package MSJW_BADA_Project.StringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import
        org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .roles("EMPLOYEE")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("OWNER");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/", "/index").permitAll()
                .antMatchers("/resources/static/**").permitAll()
                .antMatchers("/main").authenticated()
                .antMatchers("/owner/main_owner").access("hasRole('OWNER')")
                .antMatchers("/employee/main_employee").access("hasRole('EMPLOYEE')")
                .antMatchers("/owner/Post/owner_adding_post").access("hasRole('OWNER')")
                .antMatchers("/owner/**").access("hasRole('OWNER')")
                .antMatchers("/employee/**").access("hasRole('EMPLOYEE')")
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
