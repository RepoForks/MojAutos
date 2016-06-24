package moj.mojautos.injection.qualifiers;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Activity Qualifer
 */

@Qualifier
@Retention(RUNTIME)
public @interface ForActivity {
}
