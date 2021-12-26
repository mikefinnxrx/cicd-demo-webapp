package com.xerox.xcom.sample.cicd.webapp.test;

import static org.junit.Assert.assertEquals;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import com.xerox.xcom.sample.cicd.webapp.DemoService;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;

/**
 * Unit test for demo service
 * 
 * Uses the Jersey test framework
 * 
 * @author USX25284
 *
 */
public class DemoServiceTest extends JerseyTest {
	 @Override
	 public Application configure() {
	  enable(TestProperties.LOG_TRAFFIC);
	  enable(TestProperties.DUMP_ENTITY);
	  return new ResourceConfig(DemoService.class);
	 }
	 
	 @Test
	 public void testPing() {
		 Response response = target("/demo/ping").request().get();
		 assertEquals("HTTP 200",200,response.getStatus());
		 assertEquals("String response","pong",response.readEntity(String.class));
	 }
}
