/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.validation.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Benjamin Adam Nagy
 */
@Documented
@Pattern.List({@Pattern(regexp="^(([\\w(\\\\.)]+)@([\\w(\\\\.)]+))$")})
@Constraint(validatedBy={})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {

    String message() default "{net.reghours.validation.validators.Email}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
