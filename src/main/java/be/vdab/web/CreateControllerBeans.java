package be.vdab.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// enkele imports
@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
@ComponentScan
public class CreateControllerBeans extends WebMvcConfigurerAdapter {

}