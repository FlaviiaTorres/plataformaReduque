package git.flavia.PlataformaReduque.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

	
@Configuration
@EnableWebSecurit
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	    @Autowired
	    private UserDetailsServiceImpl userDetailsService;

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .csrf().disable()
	            .authorizeRequests()
	            .antMatchers("/admin/**").hasRole("ADMIN")
	            .antMatchers("/instructor/**").hasRole("INSTRUCTOR")
	            .antMatchers("/student/**").hasRole("STUDENT")
	            .antMatchers("/", "/home", "/register").permitAll()
	            .anyRequest().authenticated()
	            .and()
	            .formLogin()
	            .loginPage("/login")
	            .permitAll()
	            .and()
	            .logout()
	            .permitAll();
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	    }

	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService);
	        authProvider.setPasswordEncoder(passwordEncoder());
	        return authProvider;
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }