package classloader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyClassloader extends ClassLoader {
    private String classPath;

    MyClassloader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println(getParent());
        try {
            byte[] bytes = loadBytes(name);
            //把字节数组转化为Class对象
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException(name);
        }
    }
    //根据名称读取数据到字节数组
    private byte[] loadBytes(String name) throws Exception {
        name = name.substring(name.lastIndexOf(".") + 1);
        System.out.println(classPath + "/" + name + ".class");
        FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
        byte[] bytes = new byte[fis.available()];
        fis.read(bytes);
        fis.close();
        return bytes;
    }
}
