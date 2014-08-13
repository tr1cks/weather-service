<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">

    <meta http-equiv="refresh" content="15"/>

    <title>Погода</title>

    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/dashboard.css" rel="stylesheet">
</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">WeatherService</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Настройки</a></li>
                <li><a href="#">Профиль</a></li>
                <li><a href="#">Помощь</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input class="form-control" placeholder="Искать..." type="text">
            </form>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">Погода</a></li>
                <li><a href="#">Прогноз</a></li>
                <li><a href="#">Карта</a></li>
                <li><a href="#">Статистика</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Погода</h1>

            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <td>
                                Город (сервис)
                            </td>
                            <td>
                                Измерено (UTC)
                            </td>
                            <td>
                                Температура
                            </td>
                            <td>
                                Влажность
                            </td>
                            <td>
                                Давление
                            </td>
                            <td>
                                Направление ветра
                            </td>
                            <td>
                                Скорость ветра
                            </td>
                            <td>
                                Восход (UTC)
                            </td>
                            <td>
                                Закат (UTC)
                            </td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="observation" items="${observations}">
                            <tr>
                                <td>${observation.city.name} (${observation.weatherService.name})</td>
                                <td><fmt:formatDate value="${observation.dateTime}" pattern="HH:mm"/></td>
                                <td>${observation.temperature}</td>
                                <td>${observation.humidity}</td>
                                <td>${observation.pressure}</td>
                                <td>${observation.windDirection} (${observation.windDirectionInDegrees})</td>
                                <td>${observation.windSpeed}</td>
                                <td><fmt:formatDate value="${observation.sunrise}" pattern="HH:mm"/></td>
                                <td><fmt:formatDate value="${observation.sunset}" pattern="HH:mm"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/docs.js"></script>
</body>
</html>