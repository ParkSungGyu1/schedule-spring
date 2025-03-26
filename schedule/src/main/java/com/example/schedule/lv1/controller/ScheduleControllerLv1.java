package com.example.schedule.lv1.controller;



import com.example.schedule.lv1.service.ScheduleServiceLv1;
import com.example.schedule.lv1.dto.request.ScheduleSaveRequestDto;
import com.example.schedule.lv1.dto.response.ScheduleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleControllerLv1 {

    private final ScheduleServiceLv1 scheduleService;

    @PostMapping("/lv1/schedules")
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleSaveRequestDto requestDto) {
        return ResponseEntity.ok(scheduleService.save(requestDto));
    }

    @GetMapping("/lv1/schedules")
    public ResponseEntity<List<ScheduleResponseDto>> findAll(
            @RequestParam(required = false) String updatedDate,
            @RequestParam(required = false) String memberName) {
        return ResponseEntity.ok(scheduleService.findAll(updatedDate, memberName));
    }

    @GetMapping("/lv1/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.findScheduleById(id));
    }
}
