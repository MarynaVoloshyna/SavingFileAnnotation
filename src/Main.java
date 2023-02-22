import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        TextContainer textContainer = new TextContainer();
        Class <?> cls = TextContainer.class;
       //проверяем есть ли аннотации класса
        if(cls.isAnnotationPresent(SaveTo.class)){
            SaveTo saveTo = cls.getAnnotation(SaveTo.class);
            Method [] method = cls.getDeclaredMethods();
        //проверяем, есть аннотации методов, и если есть, вызываем такой метод для обьекта типа SaveTo
        for (Method meth:method) {
            if (meth.isAnnotationPresent(Saver.class)) {
                try {
                    meth.invoke(textContainer, saveTo.path());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
            }
        }

    }
}
