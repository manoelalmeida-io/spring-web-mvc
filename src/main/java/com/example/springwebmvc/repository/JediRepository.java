package com.example.springwebmvc.repository;

import com.example.springwebmvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {

    final List<Jedi> jedi;

    public JediRepository() {
        jedi = new ArrayList<>();
        jedi.add(new Jedi("Luke", "Skywalker"));
    }

    public List<Jedi> getAllJedi() {
        return jedi;
    }

    public void add(Jedi jedi) {
        this.jedi.add(jedi);
    }
}
