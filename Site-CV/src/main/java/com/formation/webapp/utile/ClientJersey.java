package com.formation.webapp.utile;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class ClientJersey {

	public static Client createClient() {
		ClientConfig config = new ClientConfig();
		config.register(RequestContextFilter.class);

		return ClientBuilder.newClient(config);
	}
}
