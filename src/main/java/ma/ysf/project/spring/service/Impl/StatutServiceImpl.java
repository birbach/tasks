package ma.ysf.project.spring.service.Impl;

import ma.ysf.project.spring.Dto.StatutDto;
import ma.ysf.project.spring.mapper.StatutMapper;
import ma.ysf.project.spring.repository.StatutRepository;
import ma.ysf.project.spring.service.StatutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatutServiceImpl implements StatutService {

    @Autowired
    StatutRepository statutRepository;
    @Autowired
    StatutMapper statutMapper;
    @Override
    public List<StatutDto> findAll() {
        return statutMapper.statutToStatutDto(statutRepository.findAll());
    }
}
