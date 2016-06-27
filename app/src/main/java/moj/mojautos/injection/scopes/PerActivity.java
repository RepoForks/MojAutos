package moj.mojautos.injection.scopes;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Activity Scope
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
