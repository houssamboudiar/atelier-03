<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Realestate</title>
        <link rel="stylesheet" href="./../../assets/css/bootstrap-grid.css">
        <link rel="stylesheet" href="./../../assets/css/style.css">
        <link rel="shortcut icon" href="./../../assets/images/logo.png">
    </head>
    <body>
       
        <div class="wrapper container-fluid">
            
            <header class="row" style=" background-image: url('./assets/images/bg0.jpg')">
                <div class="bg col-12"></div>
                <div class="overlay col-12"></div>
                <div class="nav col-12 row">
                    <div class="logo col-2">
                        <img class="logo_img" src="assets/images/logo.svg" alt="logo">
                    </div>
                    <nav class="navbar col-8">
                        <ul>
                            <li><a href="${ link_1 }">${ link1 }</a><span class="underline"></span></li>
                            <li><a href="${ link_2 }">${ link2 }</a><span class="underline"></span></li>
                            <li><a href="${ link_3 }">${ link3 }</a><span class="underline"></span></li>
                            <li><a href="${ link_4 }">${ link4 }</a><span class="underline"></span></li>
                            <li><a href="${ link_5 }">${ link5 }</a><span class="underline"></span></li>
                            <span class="pipe"></span>
                            <li><a href="#"> <span class="fa fa-phone"></span>Call Us</a><span class="underline"></span></li>
                        </ul>
                    </nav>
                    <div class="user col-2 ${ profile }">
                        <div class="p_pic ">
                            <img src="assets/images/p_pic.jpeg" alt="profile picture">
                            <span class="notif">7</span>
                            <span class="notif-title"><span class="arrow"></span><span class="title">Notifications</span></span>
                            <p class="username">${ user.getUsername() }</p>
                        </div>
                    </div>
                </div>

                <div class="col-12 row">
                    <div class="search col-8">
                        <p class="title">Page Not Found</p>
                    </div>

                </div>
                
                <div class="row col-12 arrow-div">
                    <div class="fa fa-angle-down"></div>
                </div>
            </header>

        </div>      

    </body>
</html>