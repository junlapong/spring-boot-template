package hello.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity https) throws Exception {
        https.authorizeRequests().antMatchers("/").permitAll().and()
             .authorizeRequests().antMatchers("/h2-console/**").permitAll();

        //https.csrf().disable();
        //https.headers().cacheControl().disable();
        https.headers().frameOptions();
        //https.headers().frameOptions().sameOrigin();
        https.headers().addHeaderWriter(new StaticHeadersWriter("X-Header", "Jman"));
    }

}
