package com.graphql.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GraphqlClientConfig
{
	private final String baseUrl;

	public GraphqlClientConfig(@Value("${graphql.server.baseUrl}") String baseUrl)
	{
		this.baseUrl = baseUrl;
	}

	@Bean
	HttpGraphQlClient graphQlClient()
	{
		WebClient client = WebClient.builder()
				.baseUrl(baseUrl)
				.build();
		return HttpGraphQlClient.builder(client).build();
	}

}
