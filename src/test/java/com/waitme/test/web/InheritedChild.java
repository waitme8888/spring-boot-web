package com.waitme.test.web;

import java.lang.annotation.Annotation;

import org.springframework.stereotype.Component;

public class InheritedChild extends InheritedParent{

	public static void main(String[] args) throws Exception {
		InheritedTest test = new InheritedChild().getClass().getAnnotation(InheritedTest.class);
		Annotation[] a = test.getClass().getSuperclass().getAnnotations();
		System.out.println(test.parentProp());
		System.out.println();
		System.out.println(InheritedTest.class);
		
		if(InheritedTest.class.isAnnotationPresent(Component.class)) {
			System.out.println("Component");
		}
		Component in = test.getClass().getAnnotation(Component.class);
		if (in != null) {
			System.out.println(in);
		}
	}
}

