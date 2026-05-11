package com.lab.lab4;

import com.lab.lab4.Museum;
import com.lab.lab4.MuseumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/museums")
@RequiredArgsConstructor
public class MuseumWebController {

    private final MuseumService service;

    // 1. Показати список усіх музеїв
    @GetMapping
    public String listMuseums(Model model) {
        model.addAttribute("museums", service.getAllMuseums());
        return "museum-list"; // назва файлу museum-list.html
    }

    // 2. Форма додавання нового музею
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("museum", new Museum());
        return "museum-form"; // назва файлу museum-form.html
    }

    // 3. Збереження музею (і нового, і відредагованого)
    @PostMapping("/save")
    public String saveMuseum(@ModelAttribute("museum") Museum museum) {
        service.saveMuseum(museum);
        return "redirect:/museums"; // перенаправлення на список
    }

    // 4. Форма редагування
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("museum", service.getMuseumById(id));
        return "museum-form";
    }

    // 5. Видалення
    @GetMapping("/delete/{id}")
    public String deleteMuseum(@PathVariable Long id) {
        service.deleteMuseum(id);
        return "redirect:/museums";
    }
}