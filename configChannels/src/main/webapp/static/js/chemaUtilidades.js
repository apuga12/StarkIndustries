
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
}