package com.graphql.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.client.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>
{
}
