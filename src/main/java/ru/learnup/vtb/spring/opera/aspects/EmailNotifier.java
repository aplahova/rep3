package ru.learnup.vtb.spring.opera.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmailNotifier {

    @Pointcut("@annotation (ru.learnup.vtb.spring.opera.annotations.EmailSend )")

    public void operaServiceNotifier() {
    }

    @After("operaServiceNotifier()")
    public void after(JoinPoint point) {
        String method = point.getSignature().getName();
        Object[] args = point.getArgs();
        String operaName = args[0].toString();

        switch (method) {
            case "addOpera":
                sendEmail("Анонс премьеры оперы '" + operaName + "'");
                break;
            case "deleteOpera":
                sendEmail("Отмена оперы '" + operaName + "'");
                break;
            case "changeOpera":
                sendEmail("Замена оперы '" + operaName + "'");
                break;
            case "buyOperaTicket":
                sendEmail("Покупка билета на оперу '" + operaName + "'");
                break;
            case "returnOperaTicket":
                sendEmail("Возврат билета на оперу '" + operaName + "'");
                break;
        }
    }

    public void sendEmail(String msg) {
        System.out.println("Отправка EMail => " + msg);
    }
}
