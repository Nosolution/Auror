package org.seec.muggle.auror.annotation;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Inherited
@Target(TYPE)
@Retention(RUNTIME)
@Mapper
@Repository
public @interface DaoMapper {
    //合并@Mapper与@Repository注解，只是为了省事
}
