package com.br.casa.service;

import com.br.casa.entity.Paciente;
import com.br.casa.exception.PacientetNaoEncontradoException;
import com.br.casa.http.domain.PacienteResponse;
import com.br.casa.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private PacienteRepository repository;

    public void salvar(Paciente paciente) {
        {
            repository.save(paciente);
        }
    }

    public List<PacienteResponse> findAll() {
        List<Paciente> entity = repository.findAll();
        List<PacienteResponse> response = new ArrayList<>();

        for (Paciente e : entity) {
            PacienteResponse paciente = new PacienteResponse();
            paciente.setNome(e.getNome());
            paciente.setCpf(e.getCpf());
            paciente.setTelefone(e.getTelefone());
        }
        return response;
    }

    public PacienteResponse findByid(Long id) throws PacientetNaoEncontradoException {
        Optional<Paciente> entity = repository.findById(id);
        if (entity.isPresent()) {
            Paciente e = entity.get();
            PacienteResponse paciente = new PacienteResponse();

            return paciente;
        } else {
            throw new PacientetNaoEncontradoException();
        }
    }

    public void deletebyId(Long id) {
        repository.deleteById(id);
    }

    public void atualizar(Long id, Paciente paciente) throws PacientetNaoEncontradoException {
        Optional<Paciente> res = repository.findById(id);
        if (res.isPresent()) {
            Paciente paciente1 = res.get();
            paciente1.setNome(paciente1.getNome());
            paciente1.setCpf(paciente1.getCpf());
            paciente1.setTelefone(paciente1.getTelefone());
            repository.save(paciente1);
        } else {
            throw new PacientetNaoEncontradoException();
        }
    }
}


