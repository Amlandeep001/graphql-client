package com.graphql.client.service;

import java.util.List;

import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;

import com.graphql.client.entity.Book;

import reactor.core.publisher.Mono;

@Service
public class BookService
{
	private final HttpGraphQlClient graphQlClient;

	public BookService(HttpGraphQlClient graphQlClient)
	{
		this.graphQlClient = graphQlClient;
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
