jQuery(function($){
//	$.getScript("/js/jquery.validate.min.js",function(){
				$(document).ready(function(){
					
					var msgRequiredGeneric = "Este campo es requerido";
					var msgMaxlength = "Cantidad de caracteres no permitidos";
					var msgRequiredEmail = "Debe ingresar un correo válido";
					var msgRequiredNumber = "Deben ser numeros";
					var msgAccept = "Formato de archivo no válido";
					var msgPhone = "Número de teléfono no válido";
					var msgMaxlengthNumber = $.validator.format("Ingrese un máximo de {0} números");
					var msgMinlengthNumber = $.validator.format("Ingrese al menos {0} números");
					var msgNumber = "Número no válido";
					var msgFecha = "La fecha debe final ser mayor a la inicial"
					var msgPassword = "Las contraseñas deben ser iguales";
					
//		======================= ALERTAS FORMULARIO PUESTO ============================================
						
					$("input[name], select[name], span.fancyFiled", "#formularioPuesto").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
//		======================= ALERTAS FORMULARIO EMPLEADO ============================================
					
					$("input[name], select[name], span.fancyFiled", "#formularioEmpleado").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
//		======================= ALERTAS FORMULARIO USUARIO ============================================
					
					$("input[name], select[name], span.fancyFiled", "#registroUsuario").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
					
//		======================= ALERTAS FORMULARIO LOGIN ============================================
					
					$("input[name], select[name], span.fancyFiled", "#loginForm").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
//		======================= ALERTAS FORMULARIO CAMBIO CONTRA ============================================
					
					$("input[name], select[name], span.fancyFiled", "#cambioContra").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
					
					$.validator.addMethod("phoneNumber", function(value, element){
						return this.optional(element) || /^[0-9]{4,4}-[0-9]{4,4}$/.test(value);
					});
					
					$.validator.addMethod("greaterStart", function (value, element, params) {
					    return this.optional(element) || $(element).val() >= $(params).val();
					});
					
//	======================= VALIDACIONES FORMULARIO USUARIO ============================================
					
					$("#registroUsuario").validate({
						rules : {
							name : {
								required : true,
							},
							lastName : {
								required : true,
							},
							email : {
								required : true,
								email: true
							},
							password : {
								required : true,
							},
							password2 : {
								required : true,
								equalTo: "#password"
							},
							
						},
						messages : {
							name : {
								required : msgRequiredGeneric,
							},
							lastName : {
								required : msgRequiredGeneric,
							},
							email : {
								required : msgRequiredGeneric,
								email: msgRequiredEmail
							},
							password : {
								required : msgRequiredGeneric,
							},
							password2 : {
								required : msgRequiredGeneric,
								equalTo: msgPassword
							},
							
							
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).addClass("is-invalid");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).addClass("is-invalid");
							}
							var isInput = $(element).is("input[type='text']");
							if (isInput) {
								$(element).addClass("is-invalid");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioPuesto").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioPuesto").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				   
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).removeClass("is-invalid");
								$(element).tooltipster("disable");
							}
				        	else if (isInputFile) {
				        		
								$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
							}
				        	else{
				        		$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
				        	} 
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					
					
//	======================= VALIDACIONES FORMULARIO LOGIN ============================================					
					
					$("#loginForm").validate({
						rules : {
							email : {
								required : true,
								email: true,
							},
							password : {
								required : true,
							},
							
						},
						messages : {
							email : {
								required : msgRequiredGeneric,
								email: msgRequiredEmail
							},
							password : {
								required : msgRequiredGeneric,
							},
							
							
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).addClass("is-invalid");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).addClass("is-invalid");
							}
							var isInput = $(element).is("input[type='text']");
							if (isInput) {
								$(element).addClass("is-invalid");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioPuesto").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioPuesto").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).removeClass("is-invalid");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
							}
				        	else{
				        		$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
				        	} 
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					
					
//	======================= VALIDACIONES FORMULARIO PUESTO ============================================					
					
					$("#formularioPuesto").validate({
						rules : {
							nombre : {
								required : true,
							},
							
						},
						messages : {
							nombre : {
								required : msgRequiredGeneric,
							},
							
							
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).addClass("is-invalid");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).addClass("is-invalid");
							}
							var isInput = $(element).is("input[type='text']");
							if (isInput) {
								$(element).addClass("is-invalid");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioPuesto").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioPuesto").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).removeClass("is-invalid");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
							}
				        	else{
				        		$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
				        	} 
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					

					
//			======================= VALIDACIONES FORMULARIO EMPLEADO ============================================
					
					
					$("#formularioEmpleado").validate({
						rules : {
							nombres : {
								required : true,
							},
							apellidos : {
								required : true,
							},
							direccion : {
								required : true,
							},
							telefono : {
								required : true,
								phoneNumber: true,
							},
							dpi : {
								required : true,
							},
							genero : {
								required : true,
							},
							fecha_nacimiento : {
								required : true,
							},
							fecha_ingreso : {
								required : true,
							},
							fecha_inicio : {
								required : true,
							},
							puesto : {
								required : true,
							},
							
							
						},
						messages : {
							nombres : {
								required : msgRequiredGeneric,
							},
							apellidos : {
								required : msgRequiredGeneric,
							},
							direccion : {
								required : msgRequiredGeneric,
							},
							telefono : {
								required : msgRequiredGeneric,
								phoneNumber: msgPhone,
							},
							dpi : {
								required : msgRequiredGeneric,
							},
							genero : {
								required : msgRequiredGeneric,
							},
							fecha_nacimiento : {
								required : msgRequiredGeneric,
							},
							fecha_ingreso : {
								required : msgRequiredGeneric,
							},
							fecha_inicio : {
								required : msgRequiredGeneric,
							},
							puesto : {
								required : msgRequiredGeneric,
							},
							
							
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).addClass("is-invalid");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).addClass("is-invalid");
							}
							var isInput = $(element).is("input[type='text']");
							if (isInput) {
								$(element).addClass("is-invalid");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioPuesto").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioPuesto").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).removeClass("is-invalid");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
							}
				        	else{
				        		$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
				        	} 
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					
//		================= GUARDAR PUESTO =================== CLICK BOTON ===================			
					
					$("#guardarPuesto").click(function(){
						var formulario = $("#formularioPuesto");
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					
					
//		================= GUARDAR EMPLEADO =================== CLICK BOTON ===================		
					
					$("#guardarEmpleado").click(function(){
						var formulario = $("#formularioEmpleado");
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					

//	   ================= GUARDAR Usuario =================== CLICK BOTON ===================		
					
					$("#guardarUsuario").click(function(){
						var formulario = $("#registroUsuario");
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
				
//		   ================= GUARDAR lOGIN =================== CLICK BOTON ===================		
				
					$("#iniciarSesion").click(function(){
						var formulario = $("#loginForm");
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
				
//					   ================= GUARDAR lOGIN =================== CLICK BOTON ===================		
					
					$("#cambiarContraseña").click(function(){
						var formulario = $("#cambioContra");
						if ($("#antigua").val())
							{
							
							}
						
//						if($(formulario).valid()){
//							$(formulario).submit();
//						}else{
//							return false;
//						}
					});
					
				
//		});
	});
});
