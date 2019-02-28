package com.fangj.exercise.usage;

import java.sql.Connection;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

/**
 * FutureTask 懒加载，避免创建多个无用的对象，尤其是包含IO操作
 *
 * @author fangjie
 * @date Created in 6:53 PM 2019/2/28.
 */
public class FutureTaskLazy {

    private static ConcurrentHashMap<String, FutureTask<Connection>> connectionPool = new ConcurrentHashMap<String, FutureTask<Connection>>();


    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            getConnection("aa");
        }
    }

    public static Connection getConnection(String key) throws Exception {
        FutureTask<Connection> connectionTask = connectionPool.get(key);
        System.out.println(connectionTask);
        if (connectionTask != null) {
            return connectionTask.get();
        } else {
            Callable<Connection> callable = new Callable<Connection>() {
                @Override
                public Connection call() throws Exception {
                    // TODO Auto-generated method stub
                    return createConnection();
                }
            };
            FutureTask<Connection> newTask = new FutureTask<Connection>(callable);
            connectionTask = connectionPool.putIfAbsent(key, newTask);
            if (connectionTask == null) {
                connectionTask = newTask;
                connectionTask.run();
            }
            return connectionTask.get();
        }
    }

    private static Connection createConnection() {
        System.out.println("create connection ...");
        return null;
    }

}
