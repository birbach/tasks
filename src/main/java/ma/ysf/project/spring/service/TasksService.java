package ma.ysf.project.spring.service;

import ma.ysf.project.spring.Dto.TasksDto;

import java.util.List;

public interface TasksService {
    public List<TasksDto> findAll();
    public void save(TasksDto tasksDto);
    public TasksDto updateTasks(Long id, TasksDto tasksDto);
    public void deleteTasks(Long id);
    public void updateStatutTaks(Long id, String code);
}
