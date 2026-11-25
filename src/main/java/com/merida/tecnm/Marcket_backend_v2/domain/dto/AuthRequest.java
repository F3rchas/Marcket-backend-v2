package com.merida.tecnm.Marcket_backend_v2.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class AuthRequest {

    @Schema(description = "Correo electrónico del cliente", example = "cliente@correo.com")
    private String correoElectronico;

    @Schema(description = "Contraseña en texto plano", example = "1234")
    private String password;

    public AuthRequest() {
    }

    public AuthRequest(String correoElectronico, String password) {
        this.correoElectronico = correoElectronico;
        this.password = password;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}





