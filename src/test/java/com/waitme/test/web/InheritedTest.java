package com.waitme.test.web;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

@Retention(RUNTIME)
@Target(TYPE)
@Inherited
@Component
public @interface InheritedTest {
	String parentProp() default "test!!!!!";
	
}
