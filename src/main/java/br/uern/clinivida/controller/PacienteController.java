package br.uern.clinivida.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.uern.clinivida.service.PacienteService;
import br.uern.clinivida.model.Paciente;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService service;
    public PacienteController(PacienteService s){ this.service = s; }

    @GetMapping
    public String listar(Model m){
        m.addAttribute("pacientes", service.listar());
        return "pacientes/listar";
    }
    @GetMapping("/novo")
    public String novoForm(Model m){
        m.addAttribute("paciente", new Paciente());
        return "pacientes/form";
    }
    @PostMapping("/salvar")
    public String salvar(Paciente paciente){
        service.salvar(paciente);
        return "redirect:/pacientes";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model m){
        service.buscar(id).ifPresent(p -> m.addAttribute("paciente", p));
        return "pacientes/form";
    }
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id){
        service.excluir(id);
        return "redirect:/pacientes";
    }
}
