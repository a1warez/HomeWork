package ru.test.homework.dz17;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String listWorkers(Model model) {
        List<Worker> workers = workerService.getAllWorkers();
        model.addAttribute("workers", workers);
        return "workerList"; // Имя Thymeleaf шаблона
    }

    @GetMapping("/new")
    public String newWorkerForm(Model model) {
        model.addAttribute("worker", new Worker());
        model.addAttribute("positions", workerService.getAllPositions());
        return "workerForm"; // Thymeleaf шаблон для формы создания
    }

    @PostMapping("/save")
    public String saveWorker(@ModelAttribute("worker") Worker worker) {
        workerService.createWorker(worker);
        return "redirect:/workers"; // Перенаправляем на список работников
    }

    @GetMapping("/edit/{id}")
    public String editWorkerForm(@PathVariable Long id, Model model) {
        Worker worker = workerService.getWorkerById(id);
        if (worker == null) {
            return "redirect:/workers"; // Обработка, если работник не найден
        }
        model.addAttribute("worker", worker);
        model.addAttribute("positions", workerService.getAllPositions());
        return "workerForm"; // Thymeleaf шаблон для формы редактирования
    }

    @GetMapping("/delete/{id}")
    public String deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
        return "redirect:/workers"; // Перенаправляем на список работников
    }
}