package com.medicaai.medicaai;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DotenvTest {

    @Test
    public void testLoadEnvVariable() {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("FIREBASE_API_KEY");
        assertNotNull(apiKey, "A variável FIREBASE_API_KEY não deve ser nula");
        System.out.println("Chave carregada com sucesso: " + apiKey);
    }
}

