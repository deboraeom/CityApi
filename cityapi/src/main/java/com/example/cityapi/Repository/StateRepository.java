package com.example.cityapi.Repository;

import com.example.cityapi.Entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
