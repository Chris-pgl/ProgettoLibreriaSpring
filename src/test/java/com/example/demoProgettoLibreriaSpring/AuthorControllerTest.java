package com.example.demoProgettoLibreriaSpring;

import com.example.demoProgettoLibreriaSpring.controllers.AuthorControllers;
import com.example.demoProgettoLibreriaSpring.entities.Author;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
class AuthorControllerTest {

	@Autowired
	private AuthorControllers authorControllers;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void AuthorControllerLoads() {
		assertThat(authorControllers).isNotNull();
	}

	private Author getAuthorFromId(Long id) throws Exception{
		MvcResult result = this.mockMvc.perform(get("/authors/" + id))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		try {
			String authorJSON = result.getResponse().getContentAsString();
			return objectMapper.readValue(authorJSON, Author.class);
		}catch (Exception e){
			return null;
		}
	}

	private Author createAAuthor()throws Exception{
		Author author = new Author();
		author.setName("Gabriele D'Annunzio");
		author.setPlaceOfBirth("Pescara");
		author.setBio("Gabriele D'Annunzio, allo stato civile Gabriele d'Annunzio," +
				" è stato uno scrittore, poeta, drammaturgo, militare, politico," +
				" giornalista e patriota italiano");
		return createAAuthor(author);
	}

	private Author createAAuthor(Author author)throws Exception{
		MvcResult result = createAAuthorRequest(author);
		Author authorFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Author.class);
		return authorFromResponse;
	}

	private MvcResult createAAuthorRequest()throws Exception{
		Author author = new Author();
		author.setName("Gabriele D'Annunzio");
		author.setPlaceOfBirth("Pescara");
		author.setBio("Gabriele D'Annunzio, allo stato civile Gabriele d'Annunzio," +
				" è stato uno scrittore, poeta, drammaturgo, militare, politico," +
				" giornalista e patriota italiano");
		return createAAuthorRequest(author);
	}

	private MvcResult createAAuthorRequest(Author author)throws Exception{
		if(author == null) return null;
		String authorJSON = objectMapper.writeValueAsString(author);

		return this.mockMvc.perform(post("/authors/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(authorJSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}


	@Test
	void createAuthorTest() throws Exception{
		Author authorFromResponse = createAAuthor();
		assertThat(authorFromResponse.getId()).isNotNull();
	}






}
