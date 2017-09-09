<<<<<<< HEAD
package com.tuyendev.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Autoinjector {
    String mappedName() default "";
    String injectType() default InjectorType.REMOTE;
    String refName() default "";
=======
package com.tuyendev.inject;		
	
import java.lang.annotation.ElementType;		
import java.lang.annotation.Retention;		
import java.lang.annotation.RetentionPolicy;		
import java.lang.annotation.Target;		
	
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})		
@Retention(RetentionPolicy.RUNTIME)		
public @interface Autoinjector {		
    String mappedName() default "";		
    String injectType() default InjectorType.REMOTE;		
    String refName() default "";		
>>>>>>> 54f57c74faa5f370060aaa9a2c023b495ad58daa
}
