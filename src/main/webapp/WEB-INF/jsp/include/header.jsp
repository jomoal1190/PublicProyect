<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">
    <link rel="icon" href="../../../images/icon/umg.png">

    <!-- Title Page-->
    <title>${pagina}</title>

    <!-- Fontfaces CSS-->
    <link href="../../../css/font-face.css" rel="stylesheet" media="all">
    <link href="../../../vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="../../../vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="../../../vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="../../../vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="../../../vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="../../../vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="../../../vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="../../../vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="../../../vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="../../../vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="../../../vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">
    <link href="../../../vendor/vector-map/jqvmap.min.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="../../../css/theme.css" rel="stylesheet" media="all">
    <link href="../../../css/tooltipster.bundle.min.css" rel="stylesheet" media="all">
     <link href="../../../css/tooltipster.bundle.min.css" rel="stylesheet" media="all">
     <link href="../../../css/bootstrap-datetimepicker.css" rel="stylesheet" media="all">
       <link href="../../../css/bootstrap-datepicker.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
    <div class="page-wrapper">
        <!-- HEADER MOBILE-->
        <header class="header-mobile d-block d-lg-none">
            <div class="header-mobile__bar">
                <div class="container-fluid">
                    <div class="header-mobile-inner">
                        <a class="logo" href="/home" style="width: 36%;">
                            <img src="../../../images/icon/umg.png" alt="Programacion2"  style="max-width: 30% !important;"/>
                            Programación 2
                        </a>
                        <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                        </button>
                    </div>
                </div>
            </div>
            <nav class="navbar-mobile">
                <div class="container-fluid">
                
                	<ul class="navbar-mobile__list list-unstyled">
                    	<c:forEach items="${menu}" var="m">
                    		<c:if test = "${m.padre == 0}">
                    		
                    		  <li class="has-sub">
                    			<a class="js-arrow" href="#">
                                <i class="${m.favicon}"></i>${m.label}</a>
                               			<ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                                			<li>
                                    			<a href="${m.path}">
                                    				<i class="${m.favicon}"></i>${m.label}
                                    			</a>
                                			</li>
                                		</ul>
                                <c:forEach items="${menu}" var="mh">
                                	<c:if test="${mh.padre == m.id}">
                                		<ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                                			<li>
                                				<c:set var="continueFor" scope="request" value="true"/>
                                				<c:forEach items="${children}" var="ch">
                                					<c:if test="${ch.padre==mh.id}">
                                					<c:set var="continueFor" scope="request" value="false"/>
                                					<ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                                					 <li class="has-sub">
<!-- 						                    			<a class="js-arrow" href="#"> -->
<%-- 						                                <i class="${mh.favicon}"></i>${mh.label}</a> --%>
						                                	<ul >
					                                			<li>
					                                    			<a href="${mh.path}">
					                                    				<i class="${mh.favicon}"></i>${mh.label}
					                                    			</a>
					                                			</li>
					                                		</ul>
						                                	<ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
					                                			<li>
					                                    			<a href="${ch.path}">
					                                    				<i class="${ch.favicon}"></i>${ch.label}
					                                    			</a>
					                                			</li>
					                                		</ul>
						                                
						                              </li>
                                					</ul>
                                						
                                					</c:if>
                                					
                                				</c:forEach>
                                				<c:if test="${continueFor != false}">
                                					<a href="${mh.path}">
                                    					<i class="${mh.favicon}"></i>${mh.label}
                                    				</a>
                                				</c:if>
                                    			
                                			</li>
                                		</ul>
                                	</c:if>
                                	
                                </c:forEach>
                                </li>
                    		</c:if>
                    		
                    	</c:forEach>
                    
                       
                            </ul>
                        </li>
                    </ul>
              
                </div>
            </nav>
        </header>
        <!-- END HEADER MOBILE-->

        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar d-none d-lg-block">
            <div class="logo">
                <a href="home">
               <img src="../../../images/icon/umg.png" alt="Programacion 2" style="max-width: 30% !important;"/>
               Programación 2
                </a>
            </div>
            
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                    <li>
                       <a href="/home">
                          <i class="fas fa-home"></i>Home
                             </a>
                    </li>
                    	<c:forEach items="${menu}" var="m">
                    		<c:if test = "${m.padre == 0}">
                    		
                    		  <li class="has-sub">
                    			<a class="js-arrow" href="#">
                                <i class="${m.favicon}"></i>${m.label}</a>
                               			<ul class="list-unstyled navbar__sub-list js-sub-list">
                                			<li>
                                    			<a href="${m.path}">
                                    				<i class="${m.favicon}"></i>${m.label}
                                    			</a>
                                			</li>
                                		</ul>
                                <c:forEach items="${menu}" var="mh">
                                	<c:if test="${mh.padre == m.id}">
                                		<ul class="list-unstyled navbar__sub-list js-sub-list">
                                			<li>
                                				<c:set var="continueFor" scope="request" value="true"/>
                                				<c:forEach items="${children}" var="ch">
                                					<c:if test="${ch.padre==mh.id}">
                                					<c:set var="continueFor" scope="request" value="false"/>
                                					<ul class="list-unstyled navbar__sub-list js-sub-list">
                                					 <li class="has-sub">
						                    			<a class="js-arrow" href="#">
						                                <i class="${mh.favicon}"></i>${mh.label}</a>
						                                	<ul class="list-unstyled navbar__sub-list js-sub-list">
					                                			<li>
					                                    			<a href="${mh.path}">
					                                    				<i class="${mh.favicon}"></i>${mh.label}
					                                    			</a>
					                                			</li>
					                                		</ul>
						                                	<ul class="list-unstyled navbar__sub-list js-sub-list">
					                                			<li>
					                                    			<a href="${ch.path}">
					                                    				<i class="${ch.favicon}"></i>${ch.label}
					                                    			</a>
					                                			</li>
					                                		</ul>
						                                
						                              </li>
                                					</ul>
                                						
                                					</c:if>
                                					
                                				</c:forEach>
                                				<c:if test="${continueFor != false}">
                                					<a href="${mh.path}">
                                    					<i class="${mh.favicon}"></i>${mh.label}
                                    				</a>
                                				</c:if>
                                    			
                                			</li>
                                		</ul>
                                	</c:if>
                                	
                                </c:forEach>
                                </li>
                    		</c:if>
                    		
                    	</c:forEach>
                    
                       
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container">
            <!-- HEADER DESKTOP-->
            <header class="header-desktop" style="height: 75px;">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap">
                            <form class="form-header" action="" method="POST">

                            </form>
                            <div class="header-button">
                                <div class="noti-wrap">
                                   
                                </div>
                                <div class="account-wrap">
                                    <div class="account-item clearfix js-item-menu">
                                        <div class="image">
                                            <img src="../../../images/user.png" alt="John Doe" />
                                        </div>
                                        <div class="content">
                                            <a class="js-acc-btn" href="#">${userName}</a>
                                        </div>
                                        <div class="account-dropdown js-dropdown">
                                            <div class="info clearfix">
                                                <div class="image">
                                                    <a href="#">
                                                        <img src="../../../images/user.png" alt="John Doe" />
                                                    </a>
                                                </div>
                                                <div class="content">
                                                    <h5 class="name">
                                                        <a href="#">${userName}</a>
                                                    </h5>
                                                    <span class="email">${emailUser}</span>
                                                </div>
                                            </div>
                                            <div class="account-dropdown__body">
                                                <div class="account-dropdown__item">
                                                    <a href="#">
                                                        <i class="zmdi zmdi-account"></i>Cuenta</a>
                                                </div>
                                                
                                            </div>
                                            <div class="account-dropdown__footer">
                                                <a href="/logout">
                                                    <i class="zmdi zmdi-power"></i>Logout</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <!-- END HEADER DESKTOP-->

            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">