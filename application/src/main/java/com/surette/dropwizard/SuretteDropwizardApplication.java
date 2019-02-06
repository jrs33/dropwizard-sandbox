package com.surette.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class SuretteDropwizardApplication extends Application<SuretteDropwizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new SuretteDropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "SuretteDropwizard";
    }

    @Override
    public void initialize(final Bootstrap<SuretteDropwizardConfiguration> bootstrap) {
    }

    @Override
    public void run(final SuretteDropwizardConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }
}
