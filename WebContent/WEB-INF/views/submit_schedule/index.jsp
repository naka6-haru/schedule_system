<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <c:choose>
            <c:when test="${schedule_date.id != null}">
                <h2>提出スケジュール一覧</h2>
                <h3>期間：${schedule_date.schedule_start} ～ ${schedule_date.schedule_last}</h3>
                <table id="submit_schedule_list">
                    <tbody>
                        <tr>
                            <th class="schedule_login_id">ID</th>
                            <th class="schedule_name">氏名</th>
                            <th class="schedule_monday">月</th>
                            <th class="schedule_tuesday">火</th>
                            <th class="schedule_wednesday">水</th>
                            <th class="schedule_thursday">木</th>
                            <th class="schedule_friday">金</th>
                            <th class="schedule_saturday">土</th>
                            <th class="schedule_sunday">日</th>
                        </tr>
                        <c:forEach var="schedule" items="${schedule}" varStatus="status">
                            <tr class="row${status.count % 2}">
                                <td class="schedule_login_id"><c:out value="${schedule.user.login_id}"/></td>
                                <td class="schedule_name"><c:out value="${schedule.user.name}"/></td>
                                <td class="schedule_monday"><c:out value="${schedule.monday1}"/> ～ <c:out value="${schedule.monday2}"/></td>
                                <td class="schedule_tuesday"><c:out value="${schedule.tuesday1}"/> ～ <c:out value="${schedule.tuesday2}"/></td>
                                <td class="schedule_wednesday"><c:out value="${schedule.wednesday1}"/> ～ <c:out value="${schedule.wednesday2}"/></td>
                                <td class="schedule_thursday"><c:out value="${schedule.thursday1}"/> ～ <c:out value="${schedule.thursday2}"/></td>
                                <td class="schedule_friday"><c:out value="${schedule.friday1}"/> ～ <c:out value="${schedule.friday2}"/></td>
                                <td class="schedule_saturday"><c:out value="${schedule.saturday1}"/> ～ <c:out value="${schedule.saturday2}"/></td>
                                <td class="schedule_sunday"><c:out value="${schedule.sunday1}"/> ～ <c:out value="${schedule.sunday2}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div id="pagination">
                    (全 ${schedule_count} 件)<br />
                    <c:forEach var="i" begin="1" end="${((schedule_count - 1) / 20) + 1}" step="1">
                        <c:choose>
                            <c:when test="${i == page}">
                                <c:out value="${i}"/>&nbsp;
                            </c:when>
                            <c:otherwise>
                                <a href="<c:url value='/?page=${i}'/>"><c:out value="${i}"/></a>&nbsp;
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </div>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
        <p><a href="<c:url value='/schedule_date/index'/>">提出スケジュール 一覧に戻る</a></p>
        <p><a href="<c:url value='/index.html'/>">トップページへ戻る</a></p>
    </c:param>
</c:import>