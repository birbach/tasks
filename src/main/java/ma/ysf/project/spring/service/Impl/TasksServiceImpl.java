package ma.ysf.project.spring.service.Impl;

import ma.ysf.project.spring.Dto.StatutDto;
import ma.ysf.project.spring.Dto.TasksDto;
import ma.ysf.project.spring.Dto.UsersDto;
import ma.ysf.project.spring.mapper.StatutMapper;
import ma.ysf.project.spring.mapper.TasksMapper;
import ma.ysf.project.spring.mapper.UsersMapper;
import ma.ysf.project.spring.model.Users;
import ma.ysf.project.spring.repository.StatutRepository;
import ma.ysf.project.spring.repository.TasksRepository;
import ma.ysf.project.spring.repository.UsersRepository;
import ma.ysf.project.spring.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import java.util.List;

@Service
public class TasksServiceImpl implements TasksService {

    private final   static String MYMAIL ="birbach18youssef@gmail.com";
    @Autowired
    TasksRepository tasksRepository;

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    TasksMapper tasksMapper;

    @Autowired
    StatutMapper statutMapper;

    @Autowired
    StatutRepository statutRepository;

    @Autowired
    private JavaMailSender emailSender;
    @Override
    public List<TasksDto> findAll() {
        return tasksMapper.tasksToTasksDto(tasksRepository.findAll());
    }

    @Override
    public void save(TasksDto tasksDto) {
        TasksDto dto = tasksMapper.tasksToTasksDto(tasksRepository.save(tasksMapper.tasksDtoToTasks(tasksDto)));
        Users sentToUser = usersRepository.findById(dto.getSentTo().getId()).get();
        Users sentByUser = usersRepository.findById(dto.getSentBy().getId()).get();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sentByUser.getEmail());
        message.setTo(sentToUser.getEmail());
        message.setSubject("Tasks for today");
        message.setText("Hello you have a new taks , good luck :) ");

        emailSender.send(message);
    }

    @Override
    public TasksDto updateTasks(Long id, TasksDto tasksDto) {
        TasksDto tasks= tasksMapper.tasksToTasksDto(tasksRepository.findById(id).get());
        tasks.setNumeroTache(tasksDto.getNumeroTache());
        tasks.setDescription(tasksDto.getDescription());
        tasks.setDateDebut(tasksDto.getDateDebut());
        tasks.setDateFin(tasksDto.getDateFin());
        tasks.setSentTo(tasksDto.getSentTo());
        tasks.setSentBy(tasksDto.getSentBy());
        tasks.setStatutDto(tasksDto.getStatutDto());
        tasksRepository.save(tasksMapper.tasksDtoToTasks(tasks));
        return tasks;
    }

    @Override
    public void deleteTasks(Long id) {
        tasksRepository.deleteById(id);
    }
    @Override
    public void updateStatutTaks(Long id, String code){
        TasksDto tasks= tasksMapper.tasksToTasksDto(tasksRepository.findById(id).get());
        StatutDto statutDto = statutMapper.statutToStatutDto(statutRepository.findByCode(code));
        tasks.setStatutDto(statutDto);

        tasksMapper.tasksToTasksDto(tasksRepository.save(tasksMapper.tasksDtoToTasks(tasks)));

    }
}
