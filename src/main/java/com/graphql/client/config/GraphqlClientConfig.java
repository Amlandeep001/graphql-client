package com.graphql.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GraphqlClientConfig
{
	@Bean
	HttpGraphQlClient graphQlClient(@Value("${graphql.server.baseUrl}") String baseUrl)
	{
		WebClient client = WebClient.builder()
				.baseUrl(baseUrl)
				.build();
		return HttpGraphQlClient.builder(client).build();
	}

}
