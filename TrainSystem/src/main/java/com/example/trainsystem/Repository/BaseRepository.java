package com.example.trainsystem.Repository;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T,Long> {

}
