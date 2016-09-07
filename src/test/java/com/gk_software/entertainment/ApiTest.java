package com.gk_software.entertainment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

    private static final String EMPTY_REQUEST = "";

    private static final String[] API = {
            "/",
            "/puzzle",
            "/init"
    };

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void serverResponds()
            throws IOException {
        // Given
        HttpEntity<String> request = new HttpEntity<String>(EMPTY_REQUEST);

        //When
        ResponseEntity response = this.restTemplate.exchange("/", HttpMethod.GET, request, String.class);

        //Than
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

    }

    @Test
    public void apiExists()
            throws IOException {
        // Given
        HttpEntity<String> request = new HttpEntity<String>(EMPTY_REQUEST);

        for (String apiPage : API) {
            //When
            ResponseEntity response = this.restTemplate.exchange(apiPage, HttpMethod.GET, request, String.class);

            //Than
            assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        }
    }
}
