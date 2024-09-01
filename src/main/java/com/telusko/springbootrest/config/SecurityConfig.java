package com.telusko.springbootrest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//This is the security configuration
    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public AuthenticationProvider authProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        //this will authenticate the user from the user details service
        provider.setUserDetailsService(userDetailsService);
        //so the password in the database must be hashed by B Crypt encryption, in postman header you should put the original password
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

        return provider;

    }





    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//         Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//             @Override
//             public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
//                 httpSecurityCsrfConfigurer.disable();
//             }
//         };
//
//         http.csrf(custCsrf);
//
//
//         Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> custHttp = new Customizer<AuthorizeHttpRequestsConfigurer<org.springframework.security.config.annotation.web.builders.HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
//             @Override
//             public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorizationManagerRequestMatcherRegistry) {
//                 authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();
//             }
//         };
//
//         http.authorizeHttpRequests(custHttp);
//
//
//
//
//         Customizer<FormLoginConfigurer<HttpSecurity>> formLoginConfigurerCustomizer = new Customizer<FormLoginConfigurer<HttpSecurity>>() {
//           @Override
//           public void customize(FormLoginConfigurer<HttpSecurity> formLoginConfigurer) {
//               formLoginConfigurer.loginPage()
//           }
//         };






        http.csrf(Customizer -> Customizer.disable());
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
//        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        return http.build();
    }

//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.
//                            withDefaultPasswordEncoder().username("user").password("1234").roles("USER").build();
//
//        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }

}
