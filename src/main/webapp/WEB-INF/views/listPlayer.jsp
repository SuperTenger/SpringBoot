<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>title</td>
    </tr>
    <c:forEach items="${players}" var="s" varStatus="st">
        <tr>
            <td>${s.id}</td>
            <td>${s.title}</td>
        </tr>
    </c:forEach>
</table>