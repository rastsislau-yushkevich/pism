<HTML>
<HEAD> <title>JAVA SERVER FACES</title> </HEAD>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<body bgcolor="white">
<f:view>
<h:form id="helloForm" >
<h2>ENTER TWO NUMBERS!!!
</h2>
<h:inputText id="userNo" value="#{UserNumberBean.userNumber}"  />// Создание поля для ввода значения и присваивание его определенной переменной
<h:inputText id="userNo2" value="#{UserNumberBean.userNumber2}" /> />// Создание поля для ввода значения и присваивание его определенной переменной
<h:commandButton id="submit" action="success" value="+" /> //Создание элемента управления кнопка
<h:commandButton id="submit2" action="success2" value="-" />
//Создание элемента управления кнопка
<p>
    </h:form>
    </f:view>
</body>
</HTML>
