<%-- 
    Document   : index
    Created on : Oct 24, 2018, 1:34:47 PM
    Author     : phil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nozomi Training Certificate Generator</title>
        <script language="javascript" type="text/javascript" src="certgen.js">
        </script>
        <link href="datepicker.css" rel="stylesheet" type="text/css">
        <link href="menu.css" rel="stylesheet" type="text/css">
    </head>
    <body onload="generateMenus()">
        Welcome to the Nozomi Training Certificate Generator
        <p>
        <form name="certInfo" action="Controller" method=GET>
            <p>
                <%--Enter Name--%>
                Trainee name: <br/>
                <input type="text" name="name">

            <p>
                <%--Enter Company--%>
                Trainee company: <br/>
                <input type="text" name="company">
            <p>
                <%--Enter Trainer--%>
                Trainer name: <br/>
                <input type="text" name="trainer">
            <p>
                <%--Enter Trainer Title--%>
                Trainer title: <br/>
                <input type="text" name="name">

            <p>
                <%--Date selector--%>
                Please select a date.
                <br />

                <input name="ADate">
                <input type=button value="select" onclick="displayDatePicker('ADate');">
                <br />
            <p>
                <%--Number of hikers --%>
                Please select the version of the software
                <br />
                <select name="version">
                    <option value="18.0.0">18.0.0</option>
                    <option value="18.0.1">18.0.1</option>
                    <option value="18.0.2">18.0.2</option>
                    <option value="18.0.3">18.0.3</option>
                    <option value="18.0.4">18.0.4</option>
                    <option value="18.1.0">18.1.0</option>
                    <option value="18.1.1">18.1.1</option>
                </select>
                <br />
            <p>

                <input type="SUBMIT">
        </form>
    </body>
</html>
