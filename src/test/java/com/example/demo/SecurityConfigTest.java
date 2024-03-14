/*
package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin", roles = "USER")
    public void testContractEndpoints_AccessGranted() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/contract/secured-endpoint"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSwaggerEndpoints_AccessGranted() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v3/api-docs"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/swagger-ui"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(aMockMvcRequestBuilders.get("/swagger-resources"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testOtherEndpoints_AuthenticationRequired() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/other-endpoint"))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Configuration
    @EnableWebSecurity
    public static class TestSecurityConfig extends WebSecurityConfigurerAdapter {

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/contract/**").hasRole("USER")
                    .antMatchers("/v3/api-docs/**", "/swagger-ui/**", "/v2/api-docs/**", "/swagger-resources/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .and()
                    .httpBasic();
        }
    }
}
*/
