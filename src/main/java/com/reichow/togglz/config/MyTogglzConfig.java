package com.reichow.togglz.config;

import java.io.File;
import java.net.URL;

import org.togglz.core.Feature;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.file.FileBasedStateRepository;
import org.togglz.core.user.SimpleFeatureUser;
import org.togglz.core.user.UserProvider;

public class MyTogglzConfig implements TogglzConfig {

	@Override
	public Class<? extends Feature> getFeatureClass() {
		return MyFeatures.class;
	}

	@Override
	public StateRepository getStateRepository() {
		return new FileBasedStateRepository(getFileFromResource());
	}

	@Override
	public UserProvider getUserProvider() {
		return () -> new SimpleFeatureUser("admin", true);
	}

	private File getFileFromResource() {
		URL resource = getClass().getClassLoader().getResource("/features.properties");
		if (resource == null) {
			throw new IllegalArgumentException("File not found! " + "/features.properties");
		} else {
			return new File(resource.getFile());
		}
	}
}
