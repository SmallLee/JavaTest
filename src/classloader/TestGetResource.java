package classloader;

import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.AlgorithmConstraints;

public class TestGetResource {
    @Test
    public void testGetresource(){
        URL url1 = getClass().getResource("");
        System.out.println(url1);//file:/D:/JavaProject/JavaTest/out/production/JavaTest/classloader/
        URL url2 = getClass().getResource("/");
        System.out.println(url2);//file:/D:/JavaProject/JavaTest/out/production/JavaTest/
    }
    @Test
    public void testClassloader() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassloader mc = new MyClassloader("d:/");
        Class<?> aClass = mc.loadClass("classloader.Test");
        Method hello = aClass.getDeclaredMethod("hello");
        hello.invoke(aClass.newInstance());
    }
}
