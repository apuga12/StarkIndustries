
// Dentro de la función del constructor se incluyen el resto de funciones Ajax.
function ObjetoAjax(){	
	// 1. Creación del Objeto XMLHttpRequest
	var xhr;
	if(window.ActiveXObject){
		//navegador IE
		xhr = new ActiveXObject("Microsoft.XMLHttp")
	} else if((window.XMLHttpRequest) || (typeof XMLHttpRequest) != undefined){
		//navegadores Firefox, Opera, Safari...
		xhr = new XMLHttpRequest();
	} else{
		//navegadores sin soporte Ajax
		//alert("Su navegador no tiene soporte para Ajax");
		xhr = null;
	}
	
	// Declaración de métodos de la clase
	this.enviar = m_enviar;
	this.respuestaTexto = m_texto;
	this.respuestaXML = m_XML;
	this.obtenerEncabezados = m_encabezados;
	this.estado = m_estado;
	this.textoEstado = m_textoEstado;
	
	// Funciones para la implementación de los métodos
	
	function m_enviar(url, method, funcionRetorno, objForm){
		var dataSend = null; 
		// Si el metodo es POST, entonces serializa los datos del form
		if(method.toLowerCase() == "post" && objForm != null){
			dataSend = obtenerDatos(objForm);
		}
		// Si el metodo es GET, serializa los datos del form y los anexa a la URL
		else if(method.toLowerCase() == "get" && objForm != null){
			var dataUrl = "";
			dataUrl = obtenerDatos(objForm);
			if(url.indexOf("?") == -1){
				url += "?"+dataUrl;
			} else{
				url += "&"+dataUrl;
			}
		}
	}
	
	// Realiza la peticion siempre en modo Asincrono
	xhr.open(method, url, true);
	xhr.onreadystatechange = function(){
		// Si la respuesta esta disponible, se ejecuta la funcion de retorno...
		if(xhr.readyState == 4){
			eval(funcionRetorno+"("+")");
		}
	};
	
	// Establece el encabezado apropiado para el envio de datos del form
	if(objForm != null){
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	}
	
	// Si es POST => dataSend va lleno, GET => dataSend = null
	xhr.send(dataSend);
	
	// Serializa los parametros del form
	function obtenerDatos(objForm){
        var controles=objForm.elements;
        var datos=new Array();
        var cad="";
        for(var i=0;i<controles.length;i++){
             cad=encodeURIComponent(controles[i].name)+"=";
             cad+=encodeURIComponent(controles[i].value);
             datos.push(cad);
        }
        //se forma la cadena con el método join() del array
        //para evitar múltiples concatenaciones
        cad=datos.join("&");
        return cad;
     }
	
	// Envio de la respuesta
	function m_texto(){
		return xhr.responseText;
	}
	function m_XML(){
		return xhr.responseXML;
	}
	function m_encabezados(){
		return xhr.getAllResponseHeaders();
	}
	
	// Estado de la respuesta
	function m_estado(){
		return xhr.status;
	}
	function m_textoEstado(){
		return xhr.statusText;
	}
}






