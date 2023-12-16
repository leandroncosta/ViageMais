package com.leandro.viagemais;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
// @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ViagemaisApplicationTests {

	// @Autowired
	// private WebTestClient webTestClient;

	// @Test
	// void registerSucess() {
	// var user = new User("ncosta", "1234", UserRole.ADMIN);

	// webTestClient
	// .post()
	// .uri("/auth/register")
	// .bodyValue(user)
	// .exchange()
	// .expectStatus().isOk();

	// }

	// @Test
	// void loginSucess() {
	// var user = new User();
	// user.setLogin("ncosta");
	// user.setPassword("1234");

	// webTestClient
	// .post()
	// .uri("/auth/login")
	// .bodyValue(user)
	// .exchange()
	// .expectStatus().isOk()
	// .expectBody()
	// .jsonPath("$.token");

	// }

	@Test
	void testCreateDestinationFailure() {
	}

}
