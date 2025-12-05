package ia32.koliada.finance.soa.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import ia32.koliada.finance.soa.dto.AuthRequest;
import ia32.koliada.finance.soa.dto.TransactionDTO;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class FinanceClient {
    private static final String BASE_URL = "http://localhost:8080/api";
    private String token; // Поле token з діаграми
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public void login(String user, String pass) {
        try {
            AuthRequest authRequest = new AuthRequest(user, pass);
            String jsonBody = mapper.writeValueAsString(authRequest);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/auth/login"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Map<String, String> result = mapper.readValue(response.body(), Map.class);
                this.token = result.get("token");
                System.out.println("[Client] Login successful. Token: " + token);
            } else {
                System.out.println("[Client] Login failed: " + response.body());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendTransaction(TransactionDTO dto) {
        if (token == null) {
            System.out.println("[Client] Error: Not authorized (No token)");
            return;
        }
        try {
            String jsonBody = mapper.writeValueAsString(dto);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/transactions"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + token) // Передача токена
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("[Client] Transaction sent. Status: " + response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getHistory() {
        if (token == null) return;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/transactions"))
                    .header("Authorization", "Bearer " + token)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("[Client] History: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FinanceClient client = new FinanceClient();
        client.login("admin", "pass");
        TransactionDTO tx = new TransactionDTO(new BigDecimal("250.00"), "Groceries", "Food");
        client.sendTransaction(tx);

        client.getHistory();
    }
}