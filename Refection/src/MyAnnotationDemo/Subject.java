package MyAnnotationDemo;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public
@Target ({ElementType.TYPE, ElementType.METHOD})//цел къде се прилага
@Retention (RetentionPolicy.RUNTIME)//ангажиране кога, можем да да получим инфо
@interface Subject {
       String[] categories() default "default";
}
@Subject(categories = {"Test", "Annotation"})
class Test{

}
