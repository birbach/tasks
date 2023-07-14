package ma.ysf.project.spring.controller;

import ma.ysf.project.spring.Dto.TasksDto;
import ma.ysf.project.spring.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/tasks/")
public class TasksController {

    @Autowired
    TasksService tasksService;

    @GetMapping(value = "both/getAllTasks")
    public List<TasksDto> findAllTasks(){
        return tasksService.findAll();
    }

    @PostMapping(value = "admin/saveTasks")
    public void saveTasks(@RequestBody TasksDto tasksDto){
         tasksService.save(tasksDto);
    }

    @PutMapping(value = "admin/updateTasks/{id}")
    public TasksDto updateTasks(@PathVariable Long id, @RequestBody TasksDto tasksDto){
        return tasksService.updateTasks(id,tasksDto);
    }

    @DeleteMapping(value = "admin/deleteTasks/{id}")
    public void deleteTasks(@PathVariable Long id){
        tasksService.deleteTasks(id);
    }

    @PutMapping(value = "both/updateStatutTasks/{id}/{code}")
    public void updateStatutTasks(@PathVariable Long id, @PathVariable String code){
         tasksService.updateStatutTaks(id,code);
    }
}
