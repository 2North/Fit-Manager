package com.example.fitmanager.repository;

import com.example.fitmanager.model.DailyRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DailyRecordRepository extends JpaRepository<DailyRecord, Long> {

    // Найти записи по дате
    List<DailyRecord> findByDate(LocalDate date);

    // Найти записи для пользователя (если добавили связь с User)
    // List<DailyRecord> findByUserId(Long userId);

    // Дополнительные методы при необходимости:
    // List<DailyRecord> findByDateBetween(LocalDate startDate, LocalDate endDate);
}