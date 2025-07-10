package ru.test.homework.ar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class sch {
    @Scheduled(fixedRate = 5000)
    public void task1() {
        System.out.println("Привет!");
    }


    @Scheduled(initialDelay = 10000, fixedRate = 15000)
    public void task2() {
        System.out.println("Задача выполняется каждые 15 секунд.");
    }


    @Scheduled(cron = "0 0 0 * * *")
    public void task3() {
        System.out.println("Текущая дата: " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
    }


    @Scheduled(cron = "0/30 * 9-17 * * *")
    public void task4() {
        System.out.println("Напоминание: рабочее время!");
    }


    @Scheduled(cron = "0 0 * * * *")
    public void task5() {
        DayOfWeek dayOfWeek = LocalDateTime.now().getDayOfWeek();
        if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
            System.out.println("Сегодня рабочий день.");
        }
    }


    @Scheduled(fixedDelay = 180000)
    public void task6() {
        LocalDateTime start = LocalDateTime.now();
        System.out.println("Начало задачи: " + start.format(DateTimeFormatter.ISO_LOCAL_TIME));
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalDateTime end = LocalDateTime.now();
        System.out.println("Окончание задачи: " + end.format(DateTimeFormatter.ISO_LOCAL_TIME));
    }


    @Value("${cron.schedule}")
    private String cronSchedule;

    @Scheduled(cron = "${cron.schedule}")
    public void task7() {
        System.out.println("Cron задача активирована.");
    }


    @Scheduled(cron = "0 0 6 * * *")
    public void task8() {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        names.forEach(name -> System.out.println("Доброе утро, " + name));
    }


    @Scheduled(cron = "0 0 4 * * SAT")
    public void task9() {
        long start = System.currentTimeMillis();
        long sum = 0;
        for (int i = 1; i <= 1000000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("Сумма: " + sum + ", время вычисления: " + (end - start) + "мс");
    }


    @Scheduled(cron = "0 0 * * * *", zone = "Europe/Moscow")
    public void task10() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Europe/Moscow"));
        System.out.println("Задача запущена в " + now.format(DateTimeFormatter.ISO_LOCAL_TIME) + " (Europe/Moscow)");
    }

    @Scheduled(fixedRate = 10000)
    public void task11() {
        Random random = new Random();
        System.out.println("Случайное число: " + (random.nextInt(100) + 1));
    }

    @Scheduled(cron = "0 59 23 * * *")
    public void task12() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfDay = now.toLocalDate().atStartOfDay();
        long seconds = java.time.Duration.between(startOfDay, now).getSeconds();
        System.out.println("Секунд с начала дня: " + seconds);
    }

    @Scheduled(fixedRate = 20000)
    public void task13() {
        int minute = LocalDateTime.now().getMinute();
        if (minute % 2 == 0) {
            System.out.println("Чётная минута");
        }
    }

    private boolean booleanValue = true;
    @Scheduled(fixedRate = 300000)
    public void task14() {
        booleanValue = !booleanValue;
        System.out.println("Текущее значение: " + booleanValue);
    }

    private List<LocalDateTime> timeList = new ArrayList<>();
    @Scheduled(fixedRate = 10000)
    public void task15Add() {
        timeList.add(LocalDateTime.now());
        System.out.println("Добавлено время. Размер списка: " + timeList.size());
    }

    @Scheduled(fixedRate = 60000)
    public void task15Clear() {
        timeList.clear();
        System.out.println("Список времени очищен.");
    }

    @Scheduled(cron = "0 0 10 * * *")
    public void task16() {
        List<String> tasks = List.of("Резервное копирование", "Отправка отчетов", "Синхронизация данных", "Оптимизация базы данных", "Проверка безопасности");
        tasks.forEach(task -> System.out.println("Выполняется задача: " + task));
    }

    @Scheduled(fixedRate = 30000)
    public void task17() {
        System.out.println("Активные потоки: " + Thread.activeCount());
    }


    @Scheduled(cron = "0 0 * * * *")
    public void task18() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endOfDay = now.toLocalDate().atTime(23, 59, 59);
        long seconds = java.time.Duration.between(now, endOfDay).getSeconds();
        System.out.println("Секунд до конца дня: " + seconds);
    }


    @Scheduled(cron = "0 * 12 * * *")
    public void task19() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Сейчас: " + now.format(DateTimeFormatter.ISO_LOCAL_TIME));
    }


    @Scheduled(fixedRate = 120000)
    public void task20() {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Elizabeth");
        names.stream()
                .filter(name -> name.length() > 5)
                .forEach(name -> System.out.println("Длинное имя: " + name));
    }
}
