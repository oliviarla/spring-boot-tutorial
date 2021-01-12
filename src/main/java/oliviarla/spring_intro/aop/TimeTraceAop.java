package oliviarla.spring_intro.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect //aop로 사용하기 위해 필요한 어노테이션
@Component //컴포넌트 스캔으로 사용할 수도 있으나 스프링 빈에 보통 등록해서 사용함
public class TimeTraceAop {

    @Around("execution(* oliviarla.spring_intro..*(..))")
    //@Around("execution(* oliviarla.spring_intro.service..*(..))") 특정 패키지만 적용 가능
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();

        System.out.println("START: "+joinPoint.toString());
        try {
            //다음 메소드로 진행
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: "+joinPoint.toString()+ timeMs + "ms");
        }

    }

}
