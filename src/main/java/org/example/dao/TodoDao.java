package org.example.dao;

import org.example.domain.Todo;
import org.example.dto.TodoDto;
import org.example.rowmapper.TodoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class TodoDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public TodoDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Todo> getAll() {
        return jdbcTemplate.query("select * from todo order by id desc", new TodoRowMapper());
    }

    public Optional<Todo> getOne(int id) {
        Todo todo = jdbcTemplate.queryForObject(
                "select * from todo where id = :id",
                Map.of("id", id),
                new TodoRowMapper()
        );
        return Optional.ofNullable(todo);
    }

    public void save(TodoDto dto) {
        String sql = "insert into todo(title, priority) values (:title, :priority)";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("title", dto.title())
                .addValue("priority", dto.priority());
        jdbcTemplate.update(sql, parameterSource);
    }

    public void update(Todo todo) {
        String sql = "update todo set title = :title, priority = :priority where id = :id";
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(todo);
        jdbcTemplate.update(sql, parameterSource);
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from todo where id = :id", Map.of("id", id));
    }
}
