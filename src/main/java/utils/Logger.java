package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class Logger {

    public static final String LEVEL_NO = "No effect";
    public static final String LEVEL_BUG = "Something wrong";
    public static final String LEVEL_EXCEPTION = "RuntimeException";
    public static final String LEVEL_CRASH = "Crashed";

    public static final String TYPE_INFO = "INFO";
    public static final String TYPE_WARNING = "WARNING";
    public static final String TYPE_ERROR = "ERROR";
    public static final String TYPE_UNEXPECTED = "UNEXPECTED";

    private static final String RuntimeLog = "[$type][$level][$time]";
    private static PrintWriter simple_log_writer;
    private static PrintWriter runtime_log_writer;

    static{
        try {
            String simple_log_path = ""; //TODO load from properties
            String runtime_log_path = ""; //TODO load from properties
            File f = new File(simple_log_path);
            if (!f.exists()){f.createNewFile();}
            simple_log_writer = new PrintWriter(new FileOutputStream(f, true), true, StandardCharsets.UTF_8);
            f = new File(runtime_log_path);
            if (!f.exists()){f.createNewFile();}
            runtime_log_writer = new PrintWriter(new FileOutputStream(f, true), true, StandardCharsets.UTF_8);
        }catch (IOException ignored){}
    }

    public static void RuntimeLog(String type, String level, Object obj, String ... others){
        String tmp = RuntimeLog;
        tmp.replace("$type", type);
        tmp.replace("$level", level);
        runtime_log_writer.print(tmp);
        runtime_log_writer.print(obj.toString());
        
    }

    public static void SimpleLog(Object obj, String ... others){
        simple_log_writer.println(obj.toString());
    }

}
