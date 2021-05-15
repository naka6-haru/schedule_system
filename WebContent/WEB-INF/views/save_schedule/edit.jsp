<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${errors != null}">
            <div id="flush_error">
                入力内容にエラーがあります。<br />
                <c:forEach var="error" items="${errors}">
                    ・<c:out value="${error}"/><br />
                </c:forEach>
            </div>
        </c:if>
        <c:choose>
            <c:when test="${save_schedule != null}">
                <h2>${save_schedule.user.name}さん ${save_schedule.schedule_date.schedule_start}～${save_schedule.schedule_date.schedule_last}</h2>
                <form method="post" action="<c:url value='/save_schedule/update?id=${save_schedule.id}' />">
                    <label for="login_id">ログインID</label><br />
                    <c:out value="${save_schedule.user.login_id}"/>
                    <br /><br />

                    <label for="name">氏名</label><br />
                    <c:out value="${save_schedule.user.name}"/>
                    <br /><br />

                    <table>
                        <tbody>
                            <tr>
                                <th>期間</th>
                                <td><c:out value="${save_schedule.schedule_date.schedule_start}"/> ～ <c:out value="${save_schedule.schedule_date.schedule_last}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>月</th>
                                <td><input type="text" size="5" maxlength="5" name="monday1" value="${save_schedule.monday1}"/> ～ <input type="text" size="5" maxlength="5" name="monday2" value="${save_schedule.monday2}"/></td>
                            </tr>
                            <tr>
                                <th>火</th>
                                <td><input type="text" size="5" maxlength="5" name="tuesday1" value="${save_schedule.tuesday1}"/> ～ <input type="text" size="5" maxlength="5" name="tuesday2" value="${save_schedule.tuesday2}"/></td>
                            </tr>
                            <tr>
                                <th>水</th>
                                <td><input type="text" size="5" maxlength="5" name="wednesday1" value="${save_schedule.wednesday1}"/> ～ <input type="text" size="5" maxlength="5" name="wednesday2" value="${save_schedule.wednesday2}"/></td>
                            </tr>
                            <tr>
                                <th>木</th>
                                <td><input type="text" size="5" maxlength="5" name="thursday1" value="${save_schedule.thursday1}"/> ～ <input type="text" size="5" maxlength="5" name="thursday2" value="${save_schedule.thursday2}"/></td>
                            </tr>
                            <tr>
                                <th>金</th>
                                <td><input type="text" size="5" maxlength="5" name="friday1" value="${save_schedule.friday1}"/> ～ <input type="text" size="5" maxlength="5" name="friday2" value="${save_schedule.friday2}"/></td>
                            </tr>                    <tr>
                                <th>土</th>
                                <td><input type="text" size="5" maxlength="5" name="saturday1" value="${save_schedule.saturday1}"/> ～ <input type="text" size="5" maxlength="5" name="saturday2" value="${save_schedule.saturday2}"/></td>
                            </tr>
                            <tr>
                                <th>日</th>
                                <td><input type="text" size="5" maxlength="5" name="sunday1" value="${save_schedule.sunday1}"/> ～ <input type="text" size="5" maxlength="5" name="sunday2" value="${save_schedule.sunday2}"/></td>
                            </tr>
                        </tbody>
                    </table>
                    <br />

                    <input type="hidden" name="_token" value="${_token}"/>
                    <button type="submit">変更</button>
                </form>
                <br />
                <p><a href="<c:url value='/save_schedule/index?id=${save_schedule.schedule_date.id}'/>">保存済みスケジュール 一覧に戻る</a>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
                <p><a href="<c:url value='/schedule_date/index'/>">スケジュール日程 一覧に戻る</a>
            </c:otherwise>
        </c:choose>
    </c:param>
</c:import>