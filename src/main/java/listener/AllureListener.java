package listener;

import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.qameta.htmlelements.statement.Listener;
import org.hamcrest.Matcher;

import java.lang.reflect.Method;
import java.util.*;

import static io.qameta.allure.Allure.getLifecycle;

public class AllureListener implements Listener {
    private Map<String,MethodFormat> loggableMethods;

    public AllureListener(){
        loggableMethods = new HashMap<>();
        loggableMethods.put("click", (description, args) -> String.format("Кликаем на элемент \'%s\'", description));
        loggableMethods.put("submit", (description, args) -> String.format("Нажимаем на элемент \'%s\'", description));
        loggableMethods.put("clear", (description, args) -> String.format("Очищаем элемент \'%s\'", description));
        loggableMethods.put("sendKeys", (description, args) -> {
            String arguments = Arrays.toString(((CharSequence[]) args[0]));
            return String.format("Вводим в элемент \'%s\' значение [%s]", description, arguments);
        });
        loggableMethods.put("waitUntil", (description, args) -> {
            Matcher matcher = (Matcher) (args[0] instanceof Matcher ? args[0] : args[1]);
            return String.format("Ждем пока элемент \'%s\' будет в состоянии [%s]", description, matcher);
        });
        loggableMethods.put("should", (description, args) -> {
            Matcher matcher = (Matcher) (args[0] instanceof Matcher ? args[0] : args[1]);
            return String.format("Проверяем что элемент \'%s\' в состоянии [%s]", description, matcher);
        });
    }

    private Optional<MethodFormat> getStepTitle(Method method) {
        return method.isDefault() ? Optional.empty() : Optional.ofNullable(loggableMethods.get(method.getName()));
    }


    public void beforeMethodCall(String description, Method method, Object[] args) {
        getStepTitle(method).ifPresent(formatter -> {
            getLifecycle().startStep(
                    UUID.randomUUID().toString(),
                    new StepResult().withName(formatter.format(description, args)).withStatus(Status.PASSED)
            );
        });
    }

    public void afterMethodCall(String description, Method method) {
        getStepTitle(method).ifPresent(title -> getLifecycle().stopStep());
    }

    @FunctionalInterface
    private interface MethodFormat {

        String format(String description, Object[] args);

    }



//   private Map loggableMethods = null;
//
//    public AllureListener() {
//        loggableMethods = new HashMap<>();
//        loggableMethods.put("click", (description, args) -> String.format("Кликаем на элемент \'%s\'", description));
//        loggableMethods.put("submit", (description, args) -> String.format("Нажимаем на элемент \'%s\'", description));
//        loggableMethods.put("clear", (description, args) -> String.format("Очищаем элемент \'%s\'", description));
//        loggableMethods.put("sendKeys", (description, args) -> {
//            String arguments = Arrays.toString(((CharSequence[]) args[0]));
//            return String.format("Вводим в элемент \'%s\' значение [%s]", description, arguments);
//        });
//        loggableMethods.put("waitUntil", (description, args) -> {
//            Matcher matcher = (Matcher) (args[0] instanceof Matcher ? args[0] : args[1]);
//            return String.format("Ждем пока элемент \'%s\' будет в состоянии [%s]", description, matcher);
//        });
//        loggableMethods.put("should", (description, args) -> {
//            Matcher matcher = (Matcher) (args[0] instanceof Matcher ? args[0] : args[1]);
//            return String.format("Проверяем что элемент \'%s\' в состоянии [%s]", description, matcher);
//        });
//    }
//
//    private Optional<MethodFormat> getStepTitle(Method method) {
//        return method.isDefault() ? Optional.empty() : Optional.ofNullable(loggableMethods.get(method.getName()));
//    }
//
//    @FunctionalInterface
//    private interface MethodFormat {
//
//        String format(String description, Object[] args);
//
//    }
}


