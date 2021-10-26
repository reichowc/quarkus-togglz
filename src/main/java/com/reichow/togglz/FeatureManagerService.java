package com.reichow.togglz;

import com.reichow.togglz.config.MyFeatures;
import javax.enterprise.context.ApplicationScoped;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.repository.FeatureState;

@ApplicationScoped
public class FeatureManagerService {

	private final FeatureManager featureManager;

	public FeatureManagerService(FeatureManager featureManager) {
		this.featureManager = featureManager;
	}

	public String validadeFeature(MyFeatures feature) {
		String name = getFeatureState(feature).getFeature().name();
		if (isActive(feature)) {
			return name + ": Active.";
		} else {
			return name + ": Not Active.";
		}
	}

	private boolean isActive(MyFeatures feature) {
		return featureManager.isActive(feature);
	}

	private FeatureState getFeatureState(MyFeatures feature) {
		return featureManager.getFeatureState(feature);
	}
}
