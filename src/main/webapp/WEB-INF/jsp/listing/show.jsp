<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Centralish"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container mt-5">
    <style>
        body {
            background-image: url('https://st2.depositphotos.com/7507618/12045/v/450/depositphotos_120454410-stock-illustration-pokeball-seamless-pattern.jpg');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-blend-mode: darken;
            background-size: cover;
        }
    </style>
    <div class="row">
        <div class="col-6">
            <div class="container-img p-3">
                <img class="w-50" alt="${listing.id}" src="${listing.image}">
            </div>
        </div>
        <div class="col-6">
            <h1>${listing.id}</h1>
            <p class="fs-2">Price: 0.${listing.price}</p>
            <p class="fs-2">Mileage : ${listing.mileage} km</p>
            <p class="fs-2">Produced Year : ${listing.produced_year}</p>
            <p class="fs-2">Description : ${listing.description}</p>
            <c:forEach items="${listing.model}" var="model>">

            </c:forEach>
        </div>
    </div>

    <%@ include file="../footer.jsp" %>
