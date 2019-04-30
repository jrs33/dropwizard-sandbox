package com.surette.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuretteDropwizardApplication extends Application<SuretteDropwizardConfiguration> {

    Logger logger = LoggerFactory.getLogger(SuretteDropwizardApplication.class);

    public static void main(final String[] args) throws Exception {
        new SuretteDropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "SuretteDropwizard";
    }

    @Override
    public void initialize(final Bootstrap<SuretteDropwizardConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );

        bootstrap.addBundle(new MigrationsBundle<SuretteDropwizardConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(SuretteDropwizardConfiguration suretteDropwizardConfiguration) {
                return suretteDropwizardConfiguration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(final SuretteDropwizardConfiguration configuration,
                    final Environment environment) {
        logger.info("DUMMY");
    }
}
