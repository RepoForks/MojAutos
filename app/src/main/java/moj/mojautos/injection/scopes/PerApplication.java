package moj.mojautos.injection.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Application Scope
 */
@Scope
@Retention(RUNTIME)
public @interface PerApplication {
}
