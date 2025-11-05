package br.uern.clinivida.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.uern.clinivida.service.MedicoService;
import br.uern.clinivida.model.Medico;

@Controller
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoService service;
    public MedicoController(MedicoService s){ this.service = s; }

    @GetMapping
    public String listar(Model m){
        m.addAttribute("medicos", service.listar());
        return "medicos/listar";
    }
    @GetMapping("/novo")
    public String novoForm(Model m){
        m.addAttribute("medico", new Medico());
        return "medicos/form";
    }
    @PostMapping("/salvar")
    public String salvar(Medico medico){
        service.salvar(medico);
        return "redirect:/medicos";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model m){
        service.buscar(id).ifPresent(p -> m.addAttribute("medico", p));
        return "medicos/form";
    }
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id){
        service.excluir(id);
        return "redirect:/medicos";
    }
}
