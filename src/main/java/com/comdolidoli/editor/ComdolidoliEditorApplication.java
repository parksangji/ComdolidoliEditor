package com.comdolidoli.editor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;


@SpringBootApplication
@Slf4j
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ComdolidoliEditorApplication implements ApplicationListener<ApplicationReadyEvent>
{
	@Value("${custom.message}")
	String message;

	public static void main(String[] args) {
		SpringApplication.run(ComdolidoliEditorApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		log.debug("######################################################");
		log.debug(message);
		log.debug("######################################################");
	}
}
