package tech.anteeone.beatsell.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterThrowing(pointcut = "execution(* tech.anteeone.beatsell.controllers..*(..))"
                    ,throwing = "ex")
    public void catchException(Exception ex) {
        logger.error("Error: ",ex);
    }

}
