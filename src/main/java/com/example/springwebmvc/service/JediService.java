package com.example.springwebmvc.service;

import com.example.springwebmvc.exception.JediNotFoundException;
import com.example.springwebmvc.model.Jedi;
import com.example.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JediService {
    @Autowired
    private JediRepository repository;

    public List<Jedi> findAll() {
        return repository.findAll();
    }

    public Jedi findById(Long id) {
        Optional<Jedi> jedi = repository.findById(id);

        if (jedi.isPresent()) {
            return jedi.get();
        } else {
            throw new JediNotFoundException();
        }
    }

    public Jedi save(Jedi jedi) {
        return repository.save(jedi);
    }

    public Jedi update(Long id, Jedi dto) {
        final Optional<Jedi> jediEntity = repository.findById(id);

        if (jediEntity.isPresent()) {
            final Jedi jedi = jediEntity.get();

            jedi.setName(dto.getName());
            jedi.setLastName(dto.getLastName());

            return repository.save(jedi);
        } else {
            throw new JediNotFoundException();
        }
    }

    public void delete(Long id) {
        final Jedi jedi = findById(id);
        repository.delete(jedi);
    }
}
