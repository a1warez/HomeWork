package ru.test.homework.dz17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private PositionRepository positionRepository;

    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    public Worker getWorkerById(Long id) {
        return workerRepository.findById(id).orElse(null); // Обработка случая, когда работник не найден
    }

    public Worker createWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    public Worker updateWorker(Long id, Worker worker) {
        Worker existingWorker = workerRepository.findById(id).orElse(null);
        if (existingWorker != null) {
            worker.setId(id); // Устанавливаем ID, чтобы обновить существующую запись
            return workerRepository.save(worker);
        }
        return null; // Обработка случая, когда работник не найден
    }

    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
    }

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }
}