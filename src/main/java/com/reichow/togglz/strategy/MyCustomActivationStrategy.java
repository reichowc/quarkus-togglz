package com.reichow.togglz.strategy;

import java.util.Arrays;
import java.util.List;

import org.togglz.core.activation.Parameter;
import org.togglz.core.activation.ParameterBuilder;
import org.togglz.core.repository.FeatureState;
import org.togglz.core.spi.ActivationStrategy;
import org.togglz.core.user.FeatureUser;

public class MyCustomActivationStrategy implements ActivationStrategy {

	private static final List<String> ALLOWED_COLORS = Arrays.asList("blue", "pink", "red", "yellow");

	@Override
	public String getId() {
		return "myCustomStrategy";
	}

	@Override
	public String getName() {
		return "My Custom Strategy";
	}

	@Override
	public Parameter[] getParameters() {
		Parameter colorParameter = ParameterBuilder.create("COLOR").label("Choose your favorite color.");
		Parameter testPropertyParameter = ParameterBuilder.create("TEST_PROPERTY").optional().label("Unuseful property.");
		return new Parameter[] { colorParameter, testPropertyParameter };
	}

	@Override
	public boolean isActive(FeatureState featureState, FeatureUser user) {
		return isColorAllowed(featureState);
	}

	public boolean isColorAllowed(FeatureState featureState) {
		String color = featureState.getParameter("COLOR").toLowerCase();
		return ALLOWED_COLORS.stream().anyMatch(e -> e.equals(color));
	}
}
