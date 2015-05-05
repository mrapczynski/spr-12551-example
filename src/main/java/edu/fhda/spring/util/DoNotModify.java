package edu.fhda.spring.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Utility annotation to mark off classes that developers are discouraged from modifying. If you discover bugs, or
 * have suggestions for an improvement, open a JIRA ticket so that the base template can be updated rather than
 * just this one application.
 *
 * @author mrapczynski, Foothill-De Anza College District, rapczynskimatthew@fhda.edu
 * @version 1.0
 */
@Retention(RetentionPolicy.SOURCE)
public @interface DoNotModify {
}
