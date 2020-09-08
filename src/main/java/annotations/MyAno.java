package annotations;

import java.lang.annotation.*;

/**
 * @Target，用来标明注解的范围，范围选择看ElemenType的源码，可喘单个，可传多个，多个用({ElementType.METHOD,ElementType.TYPE})
 * @Retention,表示注解适用于什么环境，描述生命周期
 * @Documented,表示该注解是否表示在javaodc里
 * @Inherited,表示子类可以继承父类的注解（一般必开）
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAno {

    /**
     * 这里的方法，其实是在使用注解的时候，需要填写的值，没有默认值，是必填hui
     * @return
     */
    String name();

    /**
     * 在使用注解时，可以给注解的值加上默认值，加上默认值后，该属性为选填
     * @return
     */
    int age() default 0;
}
