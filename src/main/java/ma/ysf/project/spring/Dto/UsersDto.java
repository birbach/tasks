package ma.ysf.project.spring.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersDto {

    private Long id;

    private String nom;

    private String prenom;

    private String username;

    private String password;

    private String email;

    private RoleDto roleDto;
}
