package com.example.AmongServer.reposirory;

import com.example.AmongServer.domain.entity.StartCoordinates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StartCoordinatesRepository extends JpaRepository<StartCoordinates, Long> {
}
