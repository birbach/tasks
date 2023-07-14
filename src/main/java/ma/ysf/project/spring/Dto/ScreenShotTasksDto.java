package ma.ysf.project.spring.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScreenShotTasksDto {
    private Long id;
    private String path;
    private TasksDto tasksDto;
}
