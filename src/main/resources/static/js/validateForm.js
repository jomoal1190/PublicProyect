jQuery(function($){
	$.getScript("/js/jquery.validate.min.js",function(){
				$(document).ready(function(){
					
					var msgRequiredGeneric = "Este campo es requerido";
					var msgMaxlength = "Cantidad de caracteres no permitidos";
					var msgRequiredEmail = "Debe ingresar un correo";
					var msgRequiredNumber = "Deben ser numeros";
					var msgAccept = "Formato de archivo no válido";
					var msgPhone = "Número de teléfono no válido";
					var msgMaxlengthNumber = $.validator.format("Ingrese un máximo de {0} números");
					var msgMinlengthNumber = $.validator.format("Ingrese al menos {0} números");
					var msgNumber = "Número no válido";
					var msgFecha = "La fecha debe final ser mayor a la inicial"
					
					$("input[name], select[name], span.fancyFiled", "#formularioPuesto").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
					$("input[name], select[name], span.fancyFiled", "#formularioEmpleado").tooltipster({ 
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
								$(element).parent(".selectBox").addClass("error");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).parent(".fancyFiled").addClass("error");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).parent(".fancyFiled").tooltipster("content", newError);
					                $(element).parent(".fancyFiled").tooltipster("enable");
					                $(element).parent(".fancyFiled").tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioCreateEmpleado").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioCreateEmpleado").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).parent(".selectBox").removeClass("error");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).parent(".fancyFiled").removeClass("error");
								$(element).parent(".fancyFiled").tooltipster("hide");
						        $(element).parent(".fancyFiled").tooltipster("disable");
							}
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					
					
//					VALIDACION DE EMPLEADO
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
								$(element).parent(".selectBox").addClass("error");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).parent(".fancyFiled").addClass("error");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).parent(".fancyFiled").tooltipster("content", newError);
					                $(element).parent(".fancyFiled").tooltipster("enable");
					                $(element).parent(".fancyFiled").tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioCreateEmpleado").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioCreateEmpleado").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).parent(".selectBox").removeClass("error");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).parent(".fancyFiled").removeClass("error");
								$(element).parent(".fancyFiled").tooltipster("hide");
						        $(element).parent(".fancyFiled").tooltipster("disable");
							}
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					
					
					
					$("#guardarPuesto").click(function(){
						var formulario = $("#formularioPuesto");
					
						
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					
					$("#guardarEmpleado").click(function(){
						var formulario = $("#formularioEmpleado");
					
						
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					
					
				});
		
	});
});