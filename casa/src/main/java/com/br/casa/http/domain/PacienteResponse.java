package com.br.casa.http.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PacienteResponse {

    private String nome;
    private String cpf;
    private String telefone;
}
