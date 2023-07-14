package ma.ysf.project.spring.mapper;

import ma.ysf.project.spring.Dto.StatutDto;
import ma.ysf.project.spring.Dto.TasksDto;
import ma.ysf.project.spring.Dto.UsersDto;
import ma.ysf.project.spring.model.Statut;
import ma.ysf.project.spring.model.Tasks;
import ma.ysf.project.spring.model.Users;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TasksMapper {
    @Autowired
    DozerBeanMapper mapper;

    public TasksDto tasksToTasksDto(Tasks tasks){
        TasksDto tasksDto = mapper.map(tasks,TasksDto.class);
        if (tasks.getSentTo() != null) {
            tasksDto.setSentTo(mapper.map(tasks.getSentTo(), UsersDto.class));
        }

        if (tasks.getSentBy() != null) {
            tasksDto.setSentBy(mapper.map(tasks.getSentBy(), UsersDto.class));
        }

        if (tasks.getStatut() != null) {
            tasksDto.setStatutDto(mapper.map(tasks.getStatut(), StatutDto.class));
        }
        return  tasksDto;
    }

    public List<TasksDto> tasksToTasksDto(List<Tasks> tasksList){
        List<TasksDto> tasksDtoList = new ArrayList<>();
        tasksList.forEach(tasks -> {
            tasksDtoList.add(tasksToTasksDto(tasks));
        });
        return tasksDtoList;
    }

    public Tasks tasksDtoToTasks(TasksDto tasksDto){
        Tasks tasks = mapper.map(tasksDto,Tasks.class);

        if (tasksDto.getSentTo() != null) {
            tasks.setSentTo(mapper.map(tasksDto.getSentTo(), Users.class));
        }

        if (tasksDto.getSentBy() != null) {
            tasks.setSentBy(mapper.map(tasksDto.getSentBy(), Users.class));
        }

        // Update mapping for statut
        if (tasksDto.getStatutDto() != null) {
            tasks.setStatut(mapper.map(tasksDto.getStatutDto(), Statut.class));
        }

        return tasks;
    }

    public List<Tasks> tasksDtoToTasks(List<TasksDto> tasksDtoList){
        List<Tasks> tasksList = new ArrayList<>();
        tasksDtoList.forEach(tasksDto -> {
            tasksList.add(tasksDtoToTasks(tasksDto));
        });
        return tasksList;
    }
}
