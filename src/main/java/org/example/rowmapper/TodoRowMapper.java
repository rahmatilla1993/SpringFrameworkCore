package org.example.rowmapper;

import org.example.domain.Todo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoRowMapper implements RowMapper<Todo> {
    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Todo
                .builder()
                .id(rs.getInt("id"))
                .title(rs.getString("title"))
                .priority(rs.getString("priority"))
                .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                .build();
    }
}
