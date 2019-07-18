package edu.mum.cs544.online_store.config;

import edu.mum.cs544.online_store.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaRepositories(basePackageClasses = AccountRepository.class)
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;



//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(getPasswordEncoder());
//    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{

		auth.jdbcAuthentication()
				.usersByUsernameQuery("select username, password, 1 from account where username=?")
				.authoritiesByUsernameQuery("select username, role from account where username=?")
				.dataSource(dataSource)
				.passwordEncoder(getPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
          http.authorizeRequests()
				  .antMatchers("/", "/login","/products/list","/logout","/products/addtocart","/products/removeItem").permitAll()

				  .antMatchers("/admin/**").hasRole("ADMIN")
				  .antMatchers("/checkout").hasRole("USER")
                  .anyRequest().authenticated()
				//  .antMatchers("**/checkout").authenticated()
                  .and()
            	.formLogin()
              //.loginPage("/login")
                .permitAll()
                .and()
            	.logout();
    }


}
