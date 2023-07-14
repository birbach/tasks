package ma.ysf.project.spring.mapper;

import ma.ysf.project.spring.Dto.StatutDto;
import ma.ysf.project.spring.model.Statut;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StatutMapper {

    @Autowired
    DozerBeanMapper mapper;

    public StatutDto statutToStatutDto(Statut statut){
        StatutDto statutDto = mapper.map(statut, StatutDto.class);
        return statutDto;
    }

    public List<StatutDto> statutToStatutDto(List<Statut> statutList){
        List<StatutDto> statutDtoList = new ArrayList<>();
        statutList.forEach(statut -> {
            statutDtoList.add(statutToStatutDto(statut));
        });
        return statutDtoList;
    }

    public Statut statutDtoToStatut(StatutDto statutDto){
        Statut statut = mapper.map(statutDto, Statut.class);
        return statut;
    }

    public List<Statut> statutDtoToStatut(List<StatutDto> statutDto){
        List<Statut> statutList = new ArrayList<>();
        statutDto.forEach(statut -> {
            statutList.add(statutDtoToStatut(statut));
        });
        return statutList;
    }
}
