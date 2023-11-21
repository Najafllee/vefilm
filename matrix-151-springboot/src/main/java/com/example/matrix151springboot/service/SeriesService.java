package com.example.matrix151springboot.service;
import com.example.matrix151springboot.repositories.SeriesRepository;
import com.example.matrix151springboot.exception.NotFoundException;
import com.example.matrix151springboot.mapper.SeriesMapper;
import com.example.matrix151springboot.model.SeriesViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class SeriesService {
    private final SeriesRepository seriesRepository;
    private final SeriesMapper seriesMapper;

    public List<SeriesViewDto> getSeriesList() {
        var seriesEntityList = seriesRepository.findAll();
        return   seriesEntityList.stream().map(seriesMapper::entityToDto
                )
                .collect(Collectors.toList());

    }
    public void addSeries(SeriesViewDto seriesViewDto){
        var seriesEntity = seriesMapper.dtoToEntity(seriesViewDto);
        seriesRepository.save(seriesEntity);

    }
    public void updateSeries(Long seriesId,SeriesViewDto seriesViewDto){
        var seriesEntity = seriesMapper.dtoToEntity(seriesId,seriesViewDto);
        seriesRepository.save(seriesEntity);
    }
    public void deleteSeries(Long seriesId){
        seriesRepository.deleteById(seriesId);
    }
    public SeriesViewDto getSeries(Long seriesId){
        var seriesEntity = seriesRepository.findById(seriesId).orElseThrow(
                () -> new NotFoundException("SERIES_NOT_FOUND")
        );
        return seriesMapper.entityToDto(seriesEntity);
    }


}