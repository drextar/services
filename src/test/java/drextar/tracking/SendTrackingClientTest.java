package drextar.tracking;

import drextar.application.dto.request.sendTracking.SendTrackingRequestDTO;
import drextar.infrastructure.feign.SendTrackingClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SendTrackingClientTest {

    @MockBean
    private SendTrackingClient sendTrackingClient;

    @Test
    void testSendTracking() {
        // Simulando os dados de entrada
        SendTrackingRequestDTO sendTrackingRequestDTO = new SendTrackingRequestDTO();
        sendTrackingRequestDTO.setCourier("courier-example");
        sendTrackingRequestDTO.setTrackingNumber("12345678abc");
        sendTrackingRequestDTO.setTrackingUrl("https://courier-example.com/tracking");
        sendTrackingRequestDTO.setDispatchedDate("2021-06-09");

        // Chamando o método do Feign Client
        sendTrackingClient.sendTracking("1448920500137-01", "INV123", "appKey", "appToken", sendTrackingRequestDTO);

        // Verificando se o método do Feign Client foi chamado corretamente
        verify(sendTrackingClient, times(1)).sendTracking(
                eq("1448920500137-01"), eq("INV123"), eq("appKey"), eq("appToken"), eq(sendTrackingRequestDTO));
    }

    @Test
    void testSendTrackingThrowsException() {
        // Simulando os dados de entrada
        SendTrackingRequestDTO sendTrackingRequestDTO = new SendTrackingRequestDTO();
        sendTrackingRequestDTO.setCourier("courier-example");
        sendTrackingRequestDTO.setTrackingNumber("12345678abc");
        sendTrackingRequestDTO.setTrackingUrl("https://courier-example.com/tracking");
        sendTrackingRequestDTO.setDispatchedDate("2021-06-09");

        // Configurando o mock para lançar uma exceção quando o Feign Client for chamado
        doThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request"))
                .when(sendTrackingClient).sendTracking(any(String.class), any(String.class), any(String.class), any(String.class), any(SendTrackingRequestDTO.class));

        // Chamando o método do Feign Client, esperando que uma exceção seja lançada
        try {
            sendTrackingClient.sendTracking("1448920500137-01", "INV123", "appKey", "appToken", sendTrackingRequestDTO);
        } catch (ResponseStatusException ex) {
            // Verificando se a exceção é do tipo esperado
            assertEquals(HttpStatus.BAD_REQUEST, ex.getStatusCode());
        }
    }
}



