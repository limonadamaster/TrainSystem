package com.example.trainsystem.ServiceImpl;

import com.example.trainsystem.Repository.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
public class ServiceAbstact<T> {

    private final BaseRepository<T> baseRepository;

    protected ServiceAbstact(BaseRepository<T> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public T addEntity(T entity) {
       return baseRepository.save(entity);
    }

    public T getEntityById(Long id) {
        Optional<T> object = baseRepository.findById(id);
        return object.orElse(null);
    }

    public List<T> getAllEntities() {
        return baseRepository.findAll();
    }

    public void updateEntity(T entity) {
        baseRepository.save(entity);
    }

    public void deleteEntity(Long id) {
        baseRepository.deleteById(id);
    }
}
