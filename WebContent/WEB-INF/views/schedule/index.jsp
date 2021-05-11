<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>希望スケジュール  提出一覧</h2>
        <table id="schedule_list">
            <tbody>
                <tr>
                    <th>日程</th>
                    <th>提出スケジュール</th>
                    <th>希望スケジュール</th>
                </tr>
                <c:forEach var="schedule_date" items="${schedule_dates}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${schedule_date.schedule_start}"/> ～ <c:out value="${schedule_date.schedule_last}"/></td>
                        <td><a href="<c:url value='/schedule/show?id=${schedule_date.id}'/>">詳細</a></td>
                        <td><a href="<c:url value='/schedule/new?id=${schedule_date.id}'/>">提出</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            (全 ${schedule_date_count} 件)<br />
            <c:forEach var="i" begin="1" end="${((schedule_date_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/schedule/index?page=${i}'/>"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/index.html'/>">トップページに戻る</a></p>
    </c:param>
</c:import>