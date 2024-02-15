package com.graphql.client;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.graphql.client.entity.Book;
import com.graphql.client.repository.BookRepository;
import com.graphql.client.service.BookService;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class GraphqlClientApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(GraphqlClientApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BookService service, BookRepository repository)
	{
		return args ->
		{
			Mono<List<Book>> books = service.getBooks();
			books.subscribe(repository::saveAll);
		};
	}
}
