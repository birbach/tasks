package ma.ysf.project.spring.mapper;

import ma.ysf.project.spring.Dto.ScreenShotTasksDto;
import ma.ysf.project.spring.Dto.TasksDto;
import ma.ysf.project.spring.model.ScreenShotTasks;
import ma.ysf.project.spring.model.Tasks;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScreenShotTasksMapper {
    @Autowired
    DozerBeanMapper mapper;

    public ScreenShotTasksDto screenShotTasksToScreenShotTasksDto(ScreenShotTasks screenShotTasks){
        ScreenShotTasksDto screenShotTasksDto = mapper.map(screenShotTasks,ScreenShotTasksDto.class);

        if(screenShotTasks.getTasks()!=null){
            screenShotTasks.setTasks(mapper.map(screenShotTasksDto.getTasksDto(), Tasks.class));
        }
        return screenShotTasksDto;
    }

    public List<ScreenShotTasksDto> screenShotTasksToScreenShotTasksDto(List<ScreenShotTasks> screenShotTasksList){
        List<ScreenShotTasksDto> screenShotTasksDtos = new ArrayList<>();
        screenShotTasksList.forEach(screenShotTasks -> {
            screenShotTasksDtos.add(screenShotTasksToScreenShotTasksDto(screenShotTasks));
        });
        return screenShotTasksDtos;
    }

    public ScreenShotTasks screenShotTasksDtoToScreenShotTasks(ScreenShotTasksDto screenShotTasksDto){
        ScreenShotTasks screenShotTasks = mapper.map(screenShotTasksDto, ScreenShotTasks.class);

        if(screenShotTasksDto.getTasksDto()!=null){
            screenShotTasksDto.setTasksDto(mapper.map(screenShotTasks.getTasks(), TasksDto.class));
        }
        return screenShotTasks;
    }

    public List<ScreenShotTasks> screenShotTasksDtoToScreenShotTasks(List<ScreenShotTasksDto> screenShotTasksDtoList){
        List<ScreenShotTasks> screenShotTasks = new ArrayList<>();
        screenShotTasksDtoList.forEach(screenShotTasksDto -> {
            screenShotTasks.add(screenShotTasksDtoToScreenShotTasks(screenShotTasksDto));
        });
        return screenShotTasks;
    }
}
