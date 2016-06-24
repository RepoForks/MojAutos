package moj.mojautos.injection.qualifiers;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Application Qualifier
 */

@Qualifier
@Retention(RUNTIME)
public @interface ForApplication {
}
