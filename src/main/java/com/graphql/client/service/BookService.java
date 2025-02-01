package com.graphql.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.graphql.client.entity.Book;

import reactor.core.publisher.Mono;

@Service
public class BookService
{
	private final HttpGraphQlClient graphQlClient;

	public BookService(@Value("${graphql.server.baseUrl}") String baseUrl)
	{
		WebClient client = WebClient.builder()
				.baseUrl(baseUrl)
				.build();
		graphQlClient = HttpGraphQlClient.builder(client).build();
	}

	public Mono<List<Book>> getBooks()
	{
		// language=GraphQL
		String document = """
				query {
				    allBooks{
				    	title
				    	desc
				    	author
				    	price
				    	pages
					}
				}
				""";

		Mono<List<Book>> books = graphQlClient.document(document)
				.retrieve("allBooks")
				.toEntityList(Book.class);

		return books;
	}
}
