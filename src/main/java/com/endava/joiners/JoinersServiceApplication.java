package com.endava.joiners;

import io.swagger.v3.oas.models.links.Link;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JoinersServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(JoinersServiceApplication.class, args);
	}

}
