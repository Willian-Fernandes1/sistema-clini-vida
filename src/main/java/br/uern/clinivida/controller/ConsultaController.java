package br.uern.clinivida.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.uern.clinivida.service.ConsultaService;
import br.uern.clinivida.service.PacienteService;
import br.uern.clinivida.service.MedicoService;
import br.uern.clinivida.model.Consulta;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;
    private final PacienteService pacienteService;
    private final MedicoService medicoService;

    public ConsultaController(ConsultaService cs, PacienteService ps, MedicoService ms) {
        this.consultaService = cs;
        this.pacienteService = ps;
        this.medicoService = ms;
    }

    // ✅ Lista todas as consultas
    @GetMapping
    public String listar(Model m) {
        m.addAttribute("consultas", consultaService.listar());
        return "consultas/listar";
    }

    // ✅ Exibe o formulário de nova consulta
    @GetMapping("/novo")
    public String novoForm(Model m) {
        m.addAttribute("consulta", new Consulta());
        m.addAttribute("pacientes", pacienteService.listar());
        m.addAttribute("medicos", medicoService.listar());
        return "consultas/form";
    }

    // ✅ Salva a consulta (novo ou edição)
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Consulta consulta, Model m) {
        // Verifica conflito de horário
        if (consulta.getMedico() != null && consulta.getMedico().getId() != null &&
            consulta.getData() != null && consulta.getHora() != null) {

            boolean conflito = consultaService.existeConflito(
                    consulta.getMedico().getId(),
                    consulta.getData(),
                    consulta.getHora()
            );

            if (conflito) {
                m.addAttribute("error", "❌ Conflito: médico já possui consulta neste horário");
                m.addAttribute("pacientes", pacienteService.listar());
                m.addAttribute("medicos", medicoService.listar());
                return "consultas/form";
            }
        }

        // Reassocia entidades completas (por ID)
        if (consulta.getPaciente() != null && consulta.getPaciente().getId() != null) {
            pacienteService.buscar(consulta.getPaciente().getId())
                    .ifPresent(consulta::setPaciente);
        }
        if (consulta.getMedico() != null && consulta.getMedico().getId() != null) {
            medicoService.buscar(consulta.getMedico().getId())
                    .ifPresent(consulta::setMedico);
        }

        consultaService.salvar(consulta);
        return "redirect:/consultas";
    }

    // ✅ Exclui uma consulta
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        consultaService.excluir(id);
        return "redirect:/consultas";
    }

    // ✅ Edita uma consulta existente
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model m) {
        consultaService.buscar(id).ifPresent(c -> {
            m.addAttribute("consulta", c);
            m.addAttribute("pacientes", pacienteService.listar());
            m.addAttribute("medicos", medicoService.listar());
        });
        return "consultas/form";
    }
}
