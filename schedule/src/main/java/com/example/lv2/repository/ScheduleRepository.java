package com.example.lv2.repository;


import com.example.lv2.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    Schedule save(Schedule schedule);
    List<Schedule> findAll(String updatedDate, String memberName);
    Optional<Schedule> findById(Long id);
    Schedule update(Schedule schedule);
    void deleteById(Long id);
}