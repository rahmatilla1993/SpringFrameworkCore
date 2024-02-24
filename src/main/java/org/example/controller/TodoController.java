package org.example.controller;

import org.example.domain.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@ResponseBody
public class TodoController {

    private final List<Todo> todos = List.of(
            new Todo(1, "Have a lunch", "high", LocalDateTime.now()),
            new Todo(2, "Read the book", "low", LocalDateTime.now()),
            new Todo(3, "Go to a bed", "medium", LocalDateTime.now()),
            new Todo(4, "Playing football", "high", LocalDateTime.now())
    );

    @GetMapping("/todos")
    public String getAll() {
        StringBuilder sb = new StringBuilder();
        todos.forEach(todo -> sb.append(
                """
                                <tr>
                                    <td>%s</td>
                                    <td>%s</td>
                                    <td>%s</td>
                                  </tr>
                        """.formatted(todo.getId(), todo.getTitle(), todo.getPriority())
        ));
        return """
                <table border=1>
                  <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Priority</th>
                  </tr>
                %s
                </table>
                """.formatted(sb.toString());
    }
}
