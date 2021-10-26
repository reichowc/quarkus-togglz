package com.reichow.togglz;

import com.reichow.togglz.config.MyFeatures;
import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/togglz-resource")
public class TogglzResource {

	private final FeatureManagerService featureManagerService;

	public TogglzResource(FeatureManagerService featureManagerService) {
		this.featureManagerService = featureManagerService;
	}

	@GET
	@Path("/custom-feature")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCustomFeature() {
		return featureManagerService.validadeFeature(MyFeatures.MY_CUSTOM_FEATURE);
	}

	@GET
	@Path("/system-feature")
	@Produces(MediaType.TEXT_PLAIN)
	public String getSystemPropertyFeature() {
		return featureManagerService.validadeFeature(MyFeatures.MY_SYSTEM_FEATURE);
	}

	@GET
	@Path("/system-property")
	public String editSystemProperty(@QueryParam("property") String property, @QueryParam("value") String value) {
		System.setProperty(property, value);
		return "OK";
	}

	@PostConstruct
	private void setConsoleProperties() {
		System.setProperty("togglz.console.enabled", "true");
		System.setProperty("togglz.console.secured", "false");
		System.setProperty("togglz.console.use-management-port", "false");
	}
}
