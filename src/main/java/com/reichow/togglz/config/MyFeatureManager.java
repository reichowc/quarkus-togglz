package com.reichow.togglz.config;

import java.util.ArrayList;
import java.util.List;

import com.reichow.togglz.strategy.MyCustomActivationStrategy;
import com.reichow.togglz.strategy.MySystemPropertyActivationStrategy;
import javax.enterprise.inject.Produces;
import org.togglz.core.activation.DefaultActivationStrategyProvider;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;
import org.togglz.core.spi.ActivationStrategy;
import org.togglz.core.spi.FeatureManagerProvider;

public class MyFeatureManager implements FeatureManagerProvider {

	@Override
	@Produces
	public synchronized FeatureManager getFeatureManager() {

		return new FeatureManagerBuilder()
				.togglzConfig(new MyTogglzConfig())
				.featureEnum(MyFeatures.class)
				.activationStrategyProvider(this::getActivationStrategies)
				.build();
	}

	private List<ActivationStrategy> getActivationStrategies() {
		List<ActivationStrategy> newStrategies = new ArrayList<>();
		newStrategies.add(new MyCustomActivationStrategy());
		newStrategies.add(new MySystemPropertyActivationStrategy());
		List<ActivationStrategy> defaults = new DefaultActivationStrategyProvider().getActivationStrategies();
		newStrategies.addAll(defaults);
		return newStrategies;
	}

	@Override
	public int priority() {
		return 0;
	}
}
