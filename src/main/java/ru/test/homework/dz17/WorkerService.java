package ru.test.homework.dz17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private PositionRepository positionRepository;


    public List<Worker> getAllWorkers(Sort sort) {
        return workerRepository.findAll(sort);
    }

    public Worker getWorkerById(Long id) {
        return workerRepository.findById(id).orElse(null);
    }

    public Worker createWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    public Worker updateWorker(Long id, Worker worker) {

        if (workerRepository.existsById(id)) {
            worker.setId(id);
            return workerRepository.save(worker);
        }
        return null;
    }

    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
    }

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }
}