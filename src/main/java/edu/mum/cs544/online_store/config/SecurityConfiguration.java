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

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Override this
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{

		auth.jdbcAuthentication()
				.usersByUsernameQuery("select user_name, password, 1 from account where user_name=?")
				.authoritiesByUsernameQuery("select user_name, role from account where user_name=?")
				.dataSource(dataSource);
				//.passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
          http.authorizeRequests()
				  .antMatchers("/", "/login","/logout","/products/list").permitAll()
				  .anyRequest()
				  .authenticated()
				  .antMatchers("/admin**").hasRole("ADMIN")
				  .and()
            	.formLogin()
             // .loginPage("/login")
                .permitAll()
                .and()
            	.logout();
    }
    //public void addViewControllers(ViewControllerRegistry registry) {
//  registry.addViewController("/home").setViewName("home");
//  registry.addViewController("/").setViewName("home");
//  registry.addViewController("/hello").setViewName("hello");
//  registry.addViewController("/login").setViewName("login");
//  registry.addViewController("/register").setViewName("register");
//  registry.addViewController("/userfollows").setViewName("userfollows");
//  registry.addViewController("/uploadTamplate").setViewName("uploadTamplate");
//}


}
