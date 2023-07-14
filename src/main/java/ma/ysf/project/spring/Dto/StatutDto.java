package ma.ysf.project.spring.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatutDto {
    private Long id;
    private String code;
    private String libelle;
}
