package org.example.dao;

import org.example.domain.Todo;
import org.example.dto.TodoDto;
import org.example.rowmapper.TodoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class TodoDao {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public TodoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("todo");
    }

    public List<Todo> getAll() {
        return jdbcTemplate.query("select * from todo order by id desc", new TodoRowMapper());
    }

    public Optional<Todo> getOne(int id) {
        Todo todo = jdbcTemplate.queryForObject("select * from todo where id = ?", new TodoRowMapper(), id);
        return Optional.ofNullable(todo);
    }

    public void save(TodoDto dto) {
        jdbcTemplate.update(con -> {
            var prst = con.prepareStatement("insert into todo(title, priority) values (?, ?)");
            prst.setString(1, dto.title());
            prst.setString(2, dto.priority());
            return prst;
        });
    }

    public void save2(TodoDto dto) {
        Map<String, String> map = Map.of(
                "title", dto.title(),
                "priority", dto.priority()
        );
        simpleJdbcInsert
                .usingColumns("title", "priority")
                .execute(map);
    }

    public void update(Todo todo) {
        jdbcTemplate.update("update todo set title = ?, priority = ? where id = ?",
                todo.getTitle(), todo.getPriority(), todo.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from todo where id = ?", id);
    }
}
