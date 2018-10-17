<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../../include/header.jsp" %>
					<div style="height: 80%" class="row">
                            <div class="col-md-12">
                                 <div class="card">
                                    <div class="card-header">
                                        <strong>Actualizar</strong> Empleado
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="updateEmpleado" method="post" class="" id="formularioEmpleado">
                                        	<input value="${empleado.id}" name="id" type="hidden">
                                            <div class="row">
                                            	<div class="col-6">
                                                	<label for="nombre" class=" form-control-label">Nombres</label>
                                                	<input type="text" id="nombres" name="nombres" placeholder="Nombres" class="form-control" value="${empleado.nombres}" required>
                                                </div>
                                                <div class="col-6">
                                                 	<label for="apellidos" class=" form-control-label">Apellidos</label>
                                                	<input type="text" id="apellidos" name="apellidos" placeholder="Apellidos" class="form-control" value="${empleado.apellidos}" required>
                                                </div>
                                            </div>
                                            
                                            <div class="row">
                                            	<div class="col-6">
                                            		<label for="direccion" class=" form-control-label">Dirección</label>
                                                	<input type="text" id="direccion" name="direccion" placeholder="Dirección" value="${empleado.direccion}" class="form-control" required>
                                                </div>
                                             
                                                <div class="col-6">
                                                	<label for="telefono" class=" form-control-label">Telefono</label>
                                                	<input type="text" id="telefono" name="telefono" placeholder="####-####" value="${empleado.telefono}" class="form-control" required>
                                                </div>
                                            </div>
                                           
                                          	<div class="row">
                                          		<div class="col-6">
                                                	<label for="dpi" class=" form-control-label">DPI</label>
                                                	<input type="text" id="dpi" name="dpi" placeholder="Dpi" value="${empleado.dpi}" class="form-control" required>
                                                </div>
                                                <div class="col-6">
                                                	<div class="col">
	                                                    <label class=" form-control-label">Genero</label>
	                                                </div>
	                                                <div class="col">
	                                                    <div class="form-check-inline form-check">
	                                                        <label for="inline-radio1" class="form-check-label ">
	                                                            <input type="radio" id="genero1" name="genero" value="1" class="form-check-input">Hombre
	                                                        </label>
	                                                        <label for="inline-radio2" class="form-check-label ">
	                                                            <input type="radio" id="genero2" name="genero" value="0" class="form-check-input">Mujer
	                                                        </label>
	                                                        
	                                                    </div>
	                                                </div>
	                                             </div>
                                            </div>

                                            <div class="row">
                                            	<div class="col-6">
                                                	<label for="fecha_nacimiento" class=" form-control-label">Fecha de nacimiento</label>
                                                	<input type="text" id="fecha_nacimiento" name="fecha_nacimiento" placeholder="Fecha Nacimiento" value="<fmt:formatDate value='${empleado.fechaNacimiento}' pattern='dd/MM/yyyy' />" class="form-control datepicker" data-date-format="dd/mm/yyyy" required>
                                            	</div>
                                            	<div class="col-6">
                                            		<label for="fecha_ingreso" class=" form-control-label">Fecha de ingreso</label>
                                                	<input type="text" id="fecha_ingreso" name="fecha_ingreso" placeholder="Fecha Ingreso" value="<fmt:formatDate value='${empleado.fechaInicio}' pattern='dd/MM/yyyy' />" class="form-control datepicker" data-date-format="dd/mm/yyyy" required>
                                            	</div>
                                            </div>
                                            
                                            <div class="row">
                                            	<div class="col-6">
                                                	<label for="fecha_inicio" class=" form-control-label">Fecha de inicio de labores</label>
                                                	<input type="text" id="fecha_inicio" name="fecha_inicio" placeholder="Fecha Inicio de labores" value="<fmt:formatDate value='${empleado.fechaIngreso}' pattern='dd/MM/yyyy' />" class="form-control datepicker" data-date-format="dd/mm/yyyy" required>
                                            	</div>
                                            	<div class="col-6">
                                            		 <label for="puesto" class=" form-control-label">Puesto</label>
	                                                <select id="puesto" name="puesto" class="form-control">
														  <option value="">Seleccione el puesto</option>
														  <c:forEach items="${puestos}" var="p">
														  		<option value="${p.idPuesto}">${p.nombre}</option>
														  </c:forEach>
													</select> 
                                            	</div>
                                            </div>
                                           
                                        </form>
                                    </div>
                                    <div class="card-footer">
                                        <button id="guardarEmpleado" type="submit" class="btn btn-primary btn-sm">
                                            <i class="fa fa-dot-circle-o"></i> Guardar
                                        </button>
                                        <button id="regresar" type="reset" class="btn btn-danger btn-sm">
                                            <i class="fa fa-ban"></i> Regresar
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>

<%@ include file = "../../include/footer.jsp" %>


<script>
$(document).ready(function() {
	var puesto ="${empleado.puesto.idPuesto}";
	$('#puesto option[value="'+puesto+'"]').attr("selected", "selected");
	var genero ="${empleado.genero}";
	if (genero == 1)
		{
		$("#genero1").prop("checked", true);
		}
	else{
		$("#genero2").prop("checked", true);
	}
	
	
	
	
	 $('#regresar').click(function(){
		 document.location.href = 'listEmpleados'
		}); 

	});
		
$(function () {
    $('.datepicker').datepicker({ dateFormat: 'dd/mm/yyyy' });
});


</script>