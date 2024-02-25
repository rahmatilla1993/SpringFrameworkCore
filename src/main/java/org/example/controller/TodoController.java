package org.example.controller;

import org.example.domain.Todo;
import org.example.dto.TodoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {
    private int idCount = 5;

    private final List<Todo> todos = new ArrayList<>(List.of(
            new Todo(1, "Drink the coffee", "high", LocalDateTime.now()),
            new Todo(2, "Have a lunch", "low", LocalDateTime.now()),
            new Todo(3, "Playing football", "medium", LocalDateTime.now()),
            new Todo(4, "Goto a bed", "high", LocalDateTime.now())
    ));

    @GetMapping("/all")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("todos");
        modelAndView.addObject("todoList", todos);
        return modelAndView;
    }

    @GetMapping("/add")
    public String getAddView(Model model) {
        model.addAttribute("dto", new Todo());
        return "todo_add";
    }

    @GetMapping("/edit/{id}")
    public String getEditView(@PathVariable("id") int id, Model model) {
        Todo todo = getTodoById(id);
        model.addAttribute("todo", todo);
        return "todo_edit";
    }

    @GetMapping("/delete/{id}")
    public String getDeleteView(@PathVariable("id") int id, Model model) {
        Todo todo = getTodoById(id);
        model.addAttribute("todo", todo);
        return "todo_delete";
    }

    @PostMapping("/add")
    public String addTodo(@ModelAttribute("dto") TodoDto dto) {
        Todo todo = Todo
                .builder()
                .id(idCount++)
                .title(dto.title())
                .priority(dto.priority())
                .createdAt(LocalDateTime.now())
                .build();
        todos.add(todo);
        todos.sort(Comparator.comparing(Todo::getId).reversed());
        return "redirect:/todo/all";
    }

    @PutMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, @ModelAttribute("todo") Todo todo) {
        Todo todoFromDB = getTodoById(id);
        todoFromDB.setTitle(todo.getTitle());
        todoFromDB.setPriority(todo.getPriority());
        return "redirect:/todo/all";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        Todo todo = getTodoById(id);
        todos.remove(todo);
        return "redirect:/todo/all";
    }

    private Todo getTodoById(int id) {
        return todos.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }
}
