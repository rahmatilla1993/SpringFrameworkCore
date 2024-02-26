package org.example.controller;

import org.example.dao.TodoDao;
import org.example.domain.Todo;
import org.example.dto.TodoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/todo")
public class TodoController {
    private final TodoDao todoDao;

    @Autowired
    public TodoController(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @GetMapping("/all")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("todos");
        modelAndView.addObject("todoList", todoDao.getAll());
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
        todoDao.save(dto);
        return "redirect:/todo/all";
    }

    @PutMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, @ModelAttribute("todo") Todo todo) {
        todo.setId(id);
        todoDao.update(todo);
        return "redirect:/todo/all";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        todoDao.delete(id);
        return "redirect:/todo/all";
    }

    private Todo getTodoById(int id) {
        return todoDao.getOne(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }
}
