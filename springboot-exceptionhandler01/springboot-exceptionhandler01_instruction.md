# springboot-exceptionhandler01

**springboot捕获全局异常**

## springboot捕获全局异常关键点
    1、创建全局异常处理类
        用@ControllerAdvice标识全局异常处理类
    2、在全局异常处理类中创建异常捕获方法，在方法中进行处理，value值为捕获的异常
        @ExceptionHandler(value = MyException.class)
    3、isAjax()方法是通过判断request请求是否为Ajax请求
        如果是Ajax请求的方法抛出异常，就返回错误信息
        如果不是Ajax请求的方法抛出异常，就跳转到错误页面，例如404页面、系统异常页面

## springboot捕获全局异常说明
    1、请求127.0.0.1:8080/ajaxerror，发起Ajax请求
    2、请求127.0.0.1:8080/getException，发起非Ajax请求
    3、请求127.0.0.1:8080/ajaxerror，发起非Ajax请求