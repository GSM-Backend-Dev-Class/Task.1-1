package com.gsm._8th.class4.backed.task._1._1.global.annotation.task.info;

import jakarta.annotation.PostConstruct;
import jdk.jfr.Name;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;

@Name("TaskInfo")
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface TaskInfo {
}