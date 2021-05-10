<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${errors != null}">
            <div id="flush_error">
                入力内容にエラーがあります。<br />
                <c:forEach var="error" items="${errors}">
                    ・<c:out value="${error}"  /><br />
                </c:forEach>
            </div>
        </c:if>
        <h2>スケジュール日程</h2>

        <form method="post" action="<c:url value='/schedule_date/create'/>">
            <label for="schedule_start">開始日</label><br />
            <input type="text" name="schedule_start" value="${schedule_date.schedule_start}"/>
            <br/><br/>

            <label for="schedule_last">最終日</label><br />
            <input type="text" name="schedule_last" value="${schedule_date.schedule_last}"/>
            <br /><br />

            <input type="hidden" name="_token" value="${_token}"/>
            <button type="submit">追加</button>
        </form>

        <p><a href="<c:url value='/schedule_date/index'/>">スケジュール日程 一覧に戻る</a></p>
    </c:param>
</c:import>