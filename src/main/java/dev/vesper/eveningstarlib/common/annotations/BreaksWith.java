package dev.vesper.eveningstarlib.common.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Catch all annotation for canceling breaking code when conflicts are present.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BreaksWith {
	String modId();

	String versionRange();
}
