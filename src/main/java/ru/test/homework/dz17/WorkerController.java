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
                              @RequestParam(required = false) String sortDirection,
                              @RequestParam(required = false) String name, // Параметры фильтрации
                              @RequestParam(required = false) String eurname,
                              @RequestParam(required = false) String positionType) {

        Sort sort = Sort.unsorted();

        // Обработка сортировки
        if (sortBy != null && !sortBy.isEmpty()) {
            Sort.Direction direction = Sort.Direction.ASC;
            if ("desc".equalsIgnoreCase(sortDirection)) {
                direction = Sort.Direction.DESC;
            }
            sort = Sort.by(direction, sortBy);
        }

        // Создаем FilterDTO и заполняем его значениями из параметров запроса
        FilterDTO filterDTO = new FilterDTO();
        filterDTO.setName(name);
        filterDTO.setEurname(eurname);
        filterDTO.setPositionType(positionType);

        List<Worker> workers = workerService.getAllWorkers(sort, filterDTO);  // Передаем FilterDTO в сервис
        model.addAttribute("workers", workers);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("name", name); // Передаем текущие параметры фильтрации в модель
        model.addAttribute("eurname", eurname);
        model.addAttribute("positionType", positionType);
        return "workerList"; // Имя Thymeleaf шаблона
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