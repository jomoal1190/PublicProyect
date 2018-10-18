<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "include/header.jsp" %>

           		 <div style="height: 80%" class="row">
                            <div class="col-md-12">
                                 <div class="card">
                                    <div class="card-header">
                                        <strong>Cambio </strong> contraseña
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="cambioContra" method="post" class="" id="cambioContra">
                                            <input name="idEmpleado" value="${id}" type="hidden" />
                                            <div class="form-group">
                                                <label for="antigua" class=" form-control-label">Antigua Contraseña</label>
                                                <input type="password" id="antigua" name="antigua" placeholder="Antigua Contraseña" class="form-control" required>
                                                
                                            </div>
                                            <div class="form-group">
                                                <label for="nueva" class=" form-control-label">Nueva Contraseña</label>
                                                <input type="password" id="nueva" name="nueva" placeholder="Nueva Contraseña" class="form-control" required>
                                                
                                            </div>
                                            <div class="form-group">
                                                <label for="confirmar" class=" form-control-label">Confirmar Contraseña</label>
                                                <input type="password" id="confirmar" name="confirmar" placeholder="Confirmar Contraseña" class="form-control" required>
                                                
                                            </div>
                                          
                                        </form>
                                    </div>
                                    <div class="card-footer">
                                        <button id="cambiarContraseña" type="submit" class="btn btn-primary btn-sm">
                                            <i class="fa fa-dot-circle-o"></i> Guardar
                                        </button>
                                        <button id="regresar" type="reset" class="btn btn-danger btn-sm">
                                            <i class="fa fa-ban"></i> Regresar
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
					
<%@ include file = "include/footer.jsp" %>