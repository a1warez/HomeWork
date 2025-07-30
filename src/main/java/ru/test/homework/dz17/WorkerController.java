package ru.test.homework.dz17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/workers")
public class WorkerController {

    @Autowired
    private WorkerService workerService;


    @GetMapping
    public String listWorkers(Model model,
                              @RequestParam(required = false) String sortBy,
                              @RequestParam(required = false) String sortDirection) {

        Sort sort = Sort.unsorted();


        if (sortBy != null && !sortBy.isEmpty()) {
            Sort.Direction direction = Sort.Direction.ASC;
            if ("desc".equalsIgnoreCase(sortDirection)) {
                direction = Sort.Direction.DESC;
            }
            sort = Sort.by(direction, sortBy);
        }

        List<Worker> workers = workerService.getAllWorkers(sort);
        model.addAttribute("workers", workers);


        model.addAttribute("sortBy", sortBy);
        model.addAttribute("sortDirection", sortDirection);

        return "workerList";
    }

    @GetMapping("/new")
    public String newWorkerForm(Model model) {
        model.addAttribute("worker", new Worker());
        model.addAttribute("positions", workerService.getAllPositions());
        return "workerForm";
    }

    @PostMapping("/save")
    public String saveWorker(@ModelAttribute("worker") Worker worker) {
        workerService.createWorker(worker);
        return "redirect:/workers";
    }

    @GetMapping("/edit/{id}")
    public String editWorkerForm(@PathVariable Long id, Model model) {
        Worker worker = workerService.getWorkerById(id);
        if (worker == null) {
            return "redirect:/workers";
        }
        model.addAttribute("worker", worker);
        model.addAttribute("positions", workerService.getAllPositions());
        return "workerForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
        return "redirect:/workers";
    }
}