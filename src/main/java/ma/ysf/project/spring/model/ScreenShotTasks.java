package ma.ysf.project.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SCREENSHOT_TASKS")
public class ScreenShotTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "PATH")
    private String path;
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "TASKS_ID" , nullable = true,updatable = true)
    private Tasks tasks;


}
