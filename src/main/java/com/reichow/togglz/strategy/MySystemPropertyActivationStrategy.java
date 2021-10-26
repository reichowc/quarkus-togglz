package com.reichow.togglz.strategy;

import org.togglz.core.activation.Parameter;
import org.togglz.core.activation.SystemPropertyActivationStrategy;
import org.togglz.core.repository.FeatureState;
import org.togglz.core.spi.ActivationStrategy;
import org.togglz.core.user.FeatureUser;

public class MySystemPropertyActivationStrategy extends SystemPropertyActivationStrategy implements ActivationStrategy {

	public MySystemPropertyActivationStrategy() {
		super();
	}

	@Override
	protected String getPropertyName(FeatureState featureState, String parameterName) {
		return super.getPropertyName(featureState, parameterName);
	}

	@Override
	public String getId() {
		return "mySystemPropStrategy";
	}

	@Override
	public String getName() {
		return "My System Property Strategy";
	}

	@Override
	protected String getPropertyValue(FeatureState featureState, FeatureUser user, String name) {
		return super.getPropertyValue(featureState, user, name);
	}

	@Override
	protected String getPropertyNameParam() {
		return super.getPropertyNameParam();
	}

	@Override
	protected boolean isActive(FeatureState featureState, FeatureUser user, String propertyName, String propertyValue) {
		return super.isActive(featureState, user, propertyName, propertyValue);
	}

	@Override
	public Parameter[] getParameters() {
		return super.getParameters();
	}
}
