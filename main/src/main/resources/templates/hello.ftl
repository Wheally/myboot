<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Hello World!</title>
</head>
<body>
    <h1>Hello.v.2</h1>
    <#list mybook as book>
        <p>${book}</p>
    </#list>
    <p>${hello}</p>
</body>
</html>