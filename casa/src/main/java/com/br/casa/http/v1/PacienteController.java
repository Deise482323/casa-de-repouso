package com.br.casa.http.v1;

import com.br.casa.entity.Paciente;
import com.br.casa.exception.PacientetNaoEncontradoException;
import com.br.casa.http.domain.PacienteResponse;
import com.br.casa.service.PacienteService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/api/v1/paciente")
@CrossOrigin
public class PacienteController {
    @Autowired
    private PacienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void salvar(@RequestBody Paciente paciente) {
        service.salvar(paciente);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PacienteResponse> findAll() {
        return service.findAll();
    }

    @SneakyThrows
    @GetMapping("/por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PacienteResponse findByid(@RequestParam("id") Long id) {
        return service.findByid(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(Long id) {
        service.deletebyId(id);
    }

    @PutMapping("/update-por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizar(@RequestParam("id") Long id, @RequestBody Paciente paciente) throws PacientetNaoEncontradoException {
        service.atualizar(id, paciente);
    }
}
