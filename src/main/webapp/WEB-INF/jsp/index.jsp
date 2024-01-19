<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<c:set var="title" scope="request" value="Centralish"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container">
    <h1>
        <p align="center">
            <img src="https://img.freepik.com/free-vector/super-car-sticker-text-effects-modern-esport-logo-type_36662-1068.jpg"
                 alt="Texte 'Centralish'"
            >
        </p>
    </h1>
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
        <table class="table table-striped">

            <tbody>
            <div class="row">
                <c:forEach items="${allListing}" var="listing">
                    <a class="col-4 mt-2 main-game-card" href="${s:mvcUrl('AppListing#show').arg(0, listing.id).build()}">
                        <div class="listing-card">
                            <div class="listing-card-img">
                                <img alt="${listing.id}" src="${listing.image}">
                            </div>
                            <div class="d-flex justify-content-between">
                                <p>${listing.mileage}km</p>
                                <p>${listing.price/100}€</p>
                            </div>
                        </div>
                    </a>
                </c:forEach>
            </div>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="footer.jsp" %>