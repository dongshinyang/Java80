/**
 * 
 */

function bitcamp(value) { // 예) <tr>, <strong>
	var tags;
	
	if (value.indexOf('<') == 0) {
	  tags = [document.createElement(value.substr(1,value.length - 2))]
	} else {
	  tags = document.querySelectorAll(value)
	}
	
	return tags;
}

bitcamp.ajax = function(url, settings) {
  var xhr;
  if (window.XMLHttpRequest) {
    xhr = new XMLHttpRequest();
  } else { // IE6 이하 
    xhr = new ActiveXObject("Microsoft.XMLHTTP");
  }
  
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
        if (settings.success) {
        	if (settings.dataType == "json") {
        	    settings.success(JSON.parse(xhr.responseText))
        	} else { 
        		settings.success(xhr.responseText);
        	}
        }
        
    } else if (xhr.readyState == 4 && xhr.status != 200) {
        if (settings.error) {
        	settings.error();
        }
    }
  };
  
  xhr.open(settings.method, url, true);
  xhr.send(null); 	
}





var $ = bitcamp;














