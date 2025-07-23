package ru.test.homework.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.test.homework.model.Persons;


@Controller
@RequestMapping("/home") // Базовый путь для контроллера
public class HomeController {

    @GetMapping("/cv") // Путь для отображения CV
    public String showCv(Model model) {
        // Создаем экземпляр Person и заполняем его данными
        Persons persons = new Persons();
        persons.setName("Ваше имя");
        persons.setPosition("Ваша должность");
        persons.setEmail("your.email@example.com");
        persons.setPhoneNumber("+1234567890");
        persons.setAboutMe("Краткое описание о вас.");



        model.addAttribute("person", persons);

        return "cv"; // Возвращаем имя шаблона (cv.html)
    }
}