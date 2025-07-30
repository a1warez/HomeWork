package ru.test.homework.dz17;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private EntityManager entityManager;

    public List<Worker> getAllWorkers(Sort sort, FilterDTO filterDTO) {

        return workerRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();


            if (StringUtils.hasText(filterDTO.getName())) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + filterDTO.getName().toLowerCase() + "%"));
            }


            if (StringUtils.hasText(filterDTO.getEurname())) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("eurname")), "%" + filterDTO.getEurname().toLowerCase() + "%"));
            }


            if (StringUtils.hasText(filterDTO.getPositionType())) {
                predicates.add(criteriaBuilder.equal(root.get("position").get("type"), filterDTO.getPositionType()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, sort);
    }

        public Worker getWorkerById (Long id){
            return workerRepository.findById(id).orElse(null);
        }

        public Worker createWorker (Worker worker){
            return workerRepository.save(worker);
        }

        public Worker updateWorker (Long id, Worker worker){

            if (workerRepository.existsById(id)) {
                worker.setId(id);
                return workerRepository.save(worker);
            }
            return null;
        }

        public void deleteWorker (Long id){
            workerRepository.deleteById(id);
        }

        public List<Position> getAllPositions () {
            return positionRepository.findAll();
        }

}