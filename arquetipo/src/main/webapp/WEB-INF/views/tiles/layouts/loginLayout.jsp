<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
  
  <head>
    <!-- BASE CSS -->
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/css/style.css" rel="stylesheet">
    
    
    <!-- BASE JS -->
    <script src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/baselib/jquery/js/jquery-3.2.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/baselib/jquery/plugins/dist/jquery.validate.min.js"></script>
    
    
    <!-- CREACION DE TABLAS DINAMICAS -->
     <script src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/components/data-table/media/js/jquery.dataTables.js"></script>
     <script src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/components/data-table/media/js/dataTables.bootstrap.js"></script>
    
    <!-- VALIDACIÓN Y ENVIO DE FORMULARIOS -->
    <script src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/js/form.js"></script>
    <script src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/js/form-validation.js"></script>
    
	
    </head>
    <body>


       
     
        
        <section id="site-content">
            <tiles:insertAttribute name="body" />
        </section>
         
       
</body>
</html>
    