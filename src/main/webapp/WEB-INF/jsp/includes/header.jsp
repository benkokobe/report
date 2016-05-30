<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Release Content Generator</title>

	<!-- Bootstrap -->
	<link href="/public/lib/bootstrap-3.1.1/css/bootstrap.min.css" rel="stylesheet">
	
	<link href="/public/lib/bootstrap-3.1.1/css/bootstrap.min.css" rel="stylesheet">
	

</head>
<body>
	<div class="container">
	
	<b><p class="text-right">Connected to:${env_name}</p></b>
	<b><p class="text-left">RIC: Build Manager Tool</p></b>
	
	<nav class="navbar navbar-default" role="navigation">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="/">Release Content</a></li>
	        <li><a href="/under_con">DB member type</a></li>
	        <li><a href="/under_con">Impact of Release</a></li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="/about">About</a></li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
