package com.example.demo;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@org.springframework.stereotype.Service
public class Service {
	/*@Bean
	public DataSource dataSource(){
	    return
	        (new EmbeddedDatabaseBuilder())
	        .setType(EmbeddedDatabaseType.H2) //.H2 
	        //.addScript("classpath:db/H2.schema.sql")
	        .addScript("classpath:db/data.sql")
	        .build();
	}*/
}
