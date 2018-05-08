package com.shajedul.personal.statuschamp.hello;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * The embedded server is started up on a random port by virtue of the
 * webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT and the
 * actual port is discovered at runtime with the @LocalServerPort.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private URL baseUrl;

    /**
     * Convenient alternative of RestTemplate that is suitable for integration tests.
     * They are fault tolerant, and optionally can carry Basic authentication headers.
     */
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void setup() throws Exception {
        this.baseUrl = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void testHello() throws Exception {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(baseUrl.toString(), String.class);
        assertThat(responseEntity.getBody(), equalTo("Greetings from Statuschamp!"));
    }

}
