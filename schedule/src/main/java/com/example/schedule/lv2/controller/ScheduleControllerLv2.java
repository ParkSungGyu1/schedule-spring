package com.example.schedule.lv2.controller;

import com.example.schedule.lv2.service.ScheduleServiceLv2;
import com.example.schedule.lv2.dto.request.ScheduleSaveRequestDto;
import com.example.schedule.lv2.dto.request.ScheduleUpdateRequestDto;
import com.example.schedule.lv2.dto.response.ScheduleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleControllerLv2 {

    private final ScheduleServiceLv2 scheduleServiceLv2;

    @PostMapping("/lv2/schedules")
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleSaveRequestDto requestDto) {
        return ResponseEntity.ok(scheduleServiceLv2.save(requestDto));
    }

    @GetMapping("/lv2/schedules")
    public ResponseEntity<List<ScheduleResponseDto>> findAll(
            @RequestParam(required = false) String updatedDate,
            @RequestParam(required = false) String memberName) {
        return ResponseEntity.ok(scheduleServiceLv2.findAll(updatedDate, memberName));
    }

    @GetMapping("/lv2/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleServiceLv2.findScheduleById(id));
    }


    @PutMapping("/lv2/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            @PathVariable Long id,
            @RequestBody ScheduleUpdateRequestDto request
    ) {
        return ResponseEntity.ok(scheduleServiceLv2.updateSchedule(id, request));
    }

    @DeleteMapping("/lv2/schedules/{id}")
    public void deleteSchedule(@PathVariable Long id, @RequestParam String password) {
        scheduleServiceLv2.deleteSchedule(id, password);
    }
}
