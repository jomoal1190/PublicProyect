<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

					
<%@ include file = "../../include/header.jsp" %>

					<div class="row">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35">Empleados</h3>
                                <div class="table-data__tool">
                                   
                                    <div class="table-data__tool-right">
                                        <button class="au-btn au-btn-icon au-btn--green au-btn--small" id="crear">
                                            <i class="zmdi zmdi-plus"></i>Agregar</button>
                                       
                                    </div>
                                </div>
                                <div class="table-responsive table-responsive-data2">
                                <c:if test="${not empty empleados}">
                                    <table class="table table-data2">
                                        <thead>
                                            <tr>
                                              
                                                <th>Nombres</th>
                                                <th>Apellidos</th>
                                                <th>Telefono</th>
                                                <th>Puesto</th>
                                                
                                               
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        
                                        	<c:forEach items="${empleados}" var="e">
    										<tr class="tr-shadow">
                                                <td>
                                                    ${e.nombres}
                                                </td>
                                                <td>
                                                    ${e.apellidos}
                                                </td>
                                                <td>
                                                    ${e.telefono}
                                                </td>
                                                <td>
                                                    ${e.puesto.nombre}
                                                </td>
                                               
                                                <td>
                                                    <div class="table-data-feature">
                                                        <form action="updateEmpleado" method="get" id="formUpdate-${e.id}">
                                                        <input type ="hidden" id="update-${e.id}" value="${e.id}" name="id"/>
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Editar" onclick="updateEmpleado('${e.id}')">
                                                            <i class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        </form>
                                                        
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Eliminar" onclick="eliminarEmpleado('${e.id}')">
                                                            <i class="zmdi zmdi-delete"></i>
                                                        </button>
                                                        
                                                    </div>
                                                </td>
                                           </tr>
											</c:forEach>
                                           
                                            
                                        </tbody>
                                    </table>
                                    </c:if>
                                </div>
                                <!-- END DATA TABLE -->
                            </div>
                        </div>
                      
                      

<%@ include file = "../../include/footer.jsp" %>

  <script>
  				$(document).ready(function() {
                        	
                       	 $('#crear').click(function(){
                       		 document.location.href = '/ventas/empleados/addEmpleado'
                    			}); 
                    	}); 
  						
  				function eliminarEmpleado(id)
  		     	{
  		     		console.log(id);
  		     		url="/gestion/puestos/eliminarEmpleado"
  		     		 $.ajax({                        
  			    		    type: "POST",                 
  			    		    url: url,                     
  			    		    data:{id: id},
  			    		    success: function(data)             
  			    	           {
  			    		    	if (data=="success")
  			    		    		{
  			    		    		alert("Empleado eliminado");
  			    		    		document.location.href = '/gestion/puestos/listPuestos'
  			    		    		}
  			    		    		
  			    	           }
  			    		   });
  		     	}
  		     	function updateEmpleado(id)
  		     	{
  		     		console.log(id);
  		     	 
  		    		 $("#formUpdate-"+id).submit();
  		 		
  		     	}
  				 
                        </script>