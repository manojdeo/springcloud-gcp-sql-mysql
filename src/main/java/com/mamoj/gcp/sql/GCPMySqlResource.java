package com.mamoj.gcp.sql;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GCPMySqlResource {

	private final JdbcTemplate jdbcTemplate;

	public GCPMySqlResource(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@GetMapping("/gcp")
	public List<String> getTuples() {
		return this.jdbcTemplate.queryForList("SELECT * FROM users").stream()
				.map((m) -> m.values().toString())
				.collect(Collectors.toList());
	}
}
