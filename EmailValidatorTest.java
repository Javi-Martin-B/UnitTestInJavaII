package com.vogella.unittest.email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailValidatorTest {
    @Test
    public void testCorreoValido() {
        assertTrue(EmailValidator.isValidEmail("lars.vogel@gmail.com"));
    }

    @Test
    public void testCorreoValidoConSubdominio() {
        assertTrue(EmailValidator.isValidEmail("usuario@sub.dominio.com"));
    }

    @Test
    @DisplayName("Verificar que falta dominio de nivel superior devuelve false")
    public void testFaltaDominioSuperior() {
        assertFalse(EmailValidator.isValidEmail("usuario@subdominio"));
    }

    @Test
    public void testCorreoConDosPuntosSeguidos() {
        assertFalse(EmailValidator.isValidEmail("usuario@dominio..com"));
    }

    @Test
    public void testCorreoSinNombreUsuario() {
        assertFalse(EmailValidator.isValidEmail("@dominio.com"));
    }

    @Test
    public void testCorreoVacio() {
        assertFalse(EmailValidator.isValidEmail(""));
    }

    @Test
    public void testCorreoNulo() {
        assertFalse(EmailValidator.isValidEmail(null));
    }
}
