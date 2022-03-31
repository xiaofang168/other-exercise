package com.fangj.exercise.jvm;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) {
        // class文件地址
        String myPath = "file:///E:/idea-workspace/my_test/out/production/main/"+name.replace(".","/") + ".class";
        byte[] cLassBytes = null;
        Path path;
        try {
            path = Paths.get(new URI(myPath));
            cLassBytes = Files.readAllBytes(path);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        Class clazz = defineClass(name, cLassBytes, 0, cLassBytes.length);
        return clazz;
    }

}