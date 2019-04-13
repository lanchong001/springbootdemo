### global-exception-handler : Spring MVC 全局异常处理
---
1. 创建自定义异常类 BusinessException 继承 RuntimeException
```
public class BusinessException extends RuntimeException {

    private String message;
    private Integer code;

    public BusinessException(String message, Integer code) {
        super();
        this.message = message;
        this.code = code;
    }
}
```
2. 创建全局异常处理类,进行异常处理
```
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public BusinessException exceptionHandler(BusinessException e) {
        BusinessException exception = new BusinessException(e.getMessage(), e.getCode());
        return exception;
    }
}

```
3. 创建 controller 类，并定义错误逻辑，抛出异常，参看异常实行是否被全局处理
```
@RestController
public class ExceptionController {
    @GetMapping("/exception/{id}")
    public String Demo(@PathVariable Integer id) {
        if (id < 0) {
            throw new BusinessException("输入的参数ID，必须大于0! ", -1);
        }
        return String.valueOf(id);
    }
}
```