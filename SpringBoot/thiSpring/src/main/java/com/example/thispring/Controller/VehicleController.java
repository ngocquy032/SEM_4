package com.example.thispring.Controller;

import com.example.thispring.Model.Vehicle;
import com.example.thispring.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class VehicleController {
    private VehicleRepository vehicleRepository;

    @GetMapping("/catalog")
    public String catalog(Model model) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        model.addAttribute("vehicles", vehicles);
        return "catalog";
    }

    @GetMapping("/admin/add")
    public String showAddForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "add";
    }

    @PostMapping("/admin/add")
    public String addVehicle(@ModelAttribute("vehicle") Vehicle vehicle, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }

        vehicleRepository.save(vehicle);
        return "redirect:/catalog";
    }
    @GetMapping("/admin/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Vehicle vehicle = vehicleRepository.findById((long) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid vehicle ID: " + id));
        model.addAttribute("vehicle", vehicle);
        return "edit";
    }
    @PostMapping("/admin/edit/{id}")
    public String updateVehicle(@PathVariable("id") int id, @ModelAttribute("vehicle") Vehicle vehicle,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            vehicle.setId(id);
            return "edit";
        }

        vehicleRepository.save(vehicle);
        return "redirect:/catalog";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteVehicle(@PathVariable("id") int id) {
        Vehicle vehicle = vehicleRepository.findById((long) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid vehicle ID: " + id));
        vehicleRepository.delete(vehicle);
        return "redirect:/catalog";
    }
}
