package com.medicaai.medicaai.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initializeFirebase() throws Exception {
        // Carrega as variáveis de ambiente
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("FIREBASE_API_KEY");

        // Carrega o arquivo JSON como String
        String configFilePath = "src/main/resources/firebase/medicaai-app-config.json";
        String jsonContent = new String(Files.readAllBytes(Paths.get(configFilePath)));

        // Substitui o placeholder pela chave real
        JSONObject json = new JSONObject(jsonContent);
        json.getJSONArray("client").getJSONObject(0)
                .getJSONArray("api_key").getJSONObject(0)
                .put("current_key", apiKey);

        // Inicializa o Firebase com o JSON modificado
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(
                        new FileInputStream(new File(configFilePath))))
                .setProjectId(json.getJSONObject("project_info").getString("project_id"))
                .build();

        FirebaseApp.initializeApp(options);
        System.out.println("Firebase configurado com sucesso!");
    }
}
