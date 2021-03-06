package org.bedu.java.backend.sesion8.reto2.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bedu.java.backend.sesion8.reto2.model.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;

import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureRestDocs(uriScheme = "https", uriHost = "bedu.org/rest", uriPort = 80)
@WebMvcTest(ClienteController.class)
class ClienteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void creaClienteTest() throws Exception {
        Cliente clienteParametro = Cliente.builder().nombre("Nombre").direccion("Direccion").numeroEmpleados(10).correoContacto("contacto@cliente.com").build();

        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(clienteParametro)))
                .andExpect(status().isCreated())

                .andDo(document("cliente/post-cliente",
                        requestFields(
                                fieldWithPath("id").description("El identificador del nuevo cliente"),
                                fieldWithPath("nombre").description("El nombre del cliente"),
                                fieldWithPath("direccion").description("La direcci??n del cliente"),
                                fieldWithPath("correoContacto").description("La direcci??n de correo electr??nico de contacto"),
                                fieldWithPath("numeroEmpleados").description("El n??mero de personas que trabajan en las oficinas e cliente")
                        ),
                        responseHeaders(
                                headerWithName("Location").description("La ubicaci??n del recurso (su identificador generado")
                        ))
                );
    }
}