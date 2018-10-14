<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../../../include/header.jsp" %>
					<div style="height: 80%" class="row">
                            <div class="col-md-12">
                                 <div class="card">
                                    <div class="card-header">
                                        <strong>Actualizar</strong> Puesto
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="updatePuesto" method="post" class="" id="formularioPuesto">
                                            <div class="form-group">
                                            	<input type="hidden" id="id" name="id" value="${puesto.idPuesto}" />
                                                <label for="nombre" class=" form-control-label">Nombre</label>
                                                <input type="text" id="nombre" name="nombre" placeholder="Nombre del puesto" class="form-control" value="${puesto.nombre}" required>
                                                
                                            </div>
                                          
                                        </form>
                                    </div>
                                    <div class="card-footer">
                                        <button id="guardarPuesto" type="submit" class="btn btn-primary btn-sm">
                                            <i class="fa fa-dot-circle-o"></i> Actualizar
                                        </button>
                                        <button id="regresar" type="reset" class="btn btn-danger btn-sm">
                                            <i class="fa fa-ban"></i> Regresar
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>

<%@ include file = "../../../include/footer.jsp" %>


<script>
$(document).ready(function() {
	
	
	 $('#regresar').click(function(){
		 document.location.href = '/gestion/puestos/listPuestos'
		}); 

	});
		



</script>