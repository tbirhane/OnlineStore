package edu.mum.cs544.online_store.config;

import edu.mum.cs544.online_store.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaRepositories(basePackageClasses = AccountRepository.class)
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer{
	//private static final PasswordEncoder PasswordEncoder = null;
	@Autowired
	private UserDetailsService userDetailsService;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{

		auth.userDetailsService(userDetailsService)
			.passwordEncoder(getPasswordEncoder());
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
          http.authorizeRequests()
                .antMatchers("/", "/login","/logout","/products/list").permitAll()
          		.anyRequest().authenticated()//permitAll()//authenticated()
                .and()
            .formLogin()
             //   .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
  public void addViewControllers(ViewControllerRegistry registry) {
//  registry.addViewController("/home").setViewName("home");
//  registry.addViewController("/").setViewName("home");
//  registry.addViewController("/hello").setViewName("hello");
//  registry.addViewController("/login").setViewName("login");
//  registry.addViewController("/register").setViewName("register");
//  registry.addViewController("/userfollows").setViewName("userfollows");
//  registry.addViewController("/uploadTamplate").setViewName("uploadTamplate");
}


}
