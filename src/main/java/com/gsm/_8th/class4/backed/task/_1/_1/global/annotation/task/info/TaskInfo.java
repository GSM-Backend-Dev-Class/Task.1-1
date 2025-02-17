package com.gsm._8th.class4.backed.task._1._1.global.annotation.task.info;

import jakarta.annotation.PostConstruct;
import jdk.jfr.Name;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 과제 정보를 출력하는 클래스에 적용되는 어노테이션
 *
 * @Componset 어노테이션을 사용하여 빈으로 등록된 클래스에 적용
 * @Slf4j 어노테이션을 사용하여 로깅을 위한 Logger 객체를 생성
 * 어노테이션은 런타임에도 유지되어야 하므로 @Retention 어노테이션을 사용하여 런타임에도 유지되도록 함
 */
@Name("TaskInfo")
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface TaskInfo {
}