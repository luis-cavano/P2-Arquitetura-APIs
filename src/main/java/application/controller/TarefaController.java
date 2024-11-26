package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.record.TarefaDTO;
import application.service.TarefaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("tarefa")
@SecurityRequirement(name = "bearer-key")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public Iterable<TarefaDTO> findAll() {
        return tarefaService.findAll();
    }

    @GetMapping("/{id}")
    public TarefaDTO findById(@PathVariable long id) {
        return tarefaService.findById(id);
    }

    @PostMapping
    public TarefaDTO insert(@RequestBody TarefaDTO tarefaDTO) {
        return tarefaService.insert(tarefaDTO);
    }

    @PutMapping("/{id}")
    public TarefaDTO update(
            @PathVariable long id,
            @RequestBody TarefaDTO tarefaDTO) {
        return tarefaService.update(id, tarefaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable long id) {
        tarefaService.delete(id);
    }

    @PostMapping("/{tarefaId}/{colaboradorId}")
    public void insertColaborador(@PathVariable Long tarefaId, @PathVariable Long colaboradorId) {
        tarefaService.insertColaborador(tarefaId, colaboradorId);
    }

    @DeleteMapping("/{tarefaId}/{colaboradorId}")
    public void deleteColaborador(@PathVariable Long tarefaId, @PathVariable Long colaboradorId) {
        tarefaService.deleteColaborador(tarefaId, colaboradorId);
    }
}