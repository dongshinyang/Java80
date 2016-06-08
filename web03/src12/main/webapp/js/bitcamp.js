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
	
	// 태그 목록을 리턴하기 전에 프로그래밍 할 때 편리하게 사용할 양념을 뿌려두자!
	tags.click = function(cb) {
		for (var i = 0; i < this.length; i++) {
			this[i].addEventListener("click", cb);
		}
		return this;
	}
	
	tags.css = function(propName, value) {
		for (var i = 0; i < this.length; i++) {
			this[i].style[propName] = value;
		}
		return this;
	}
	
	tags.val = function(value) {
		if (value != undefined) {
			for (var i = 0; i < this.length; i++) {
				this[i].value = value;
			}
			return this;
		} else {
			return this[0].value;
		}
	}
	
	tags.html = function(value) {
		if (value != undefined) {
			for (var i = 0; i < this.length; i++) {
				this[i].innerHTML = value;
			}
			return this;
		} else {
			return this[0].innerHTML;
		}
	}
	
	tags.append = function(childs) {
		for (var i = 0; i < this.length; i++) {
			for (var j = 0; j < childs.length; j++) {
				this[i].appendChild(childs[j]);
			}
		}
		return this;
	}
	
	tags.appendTo = function(parents) {
		for (var i = 0; i < parents.length; i++) {
			for (var j = 0; j < this.length; j++) {
				parents[i].appendChild(this[j]);
			}
		}
		return this;
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
  
  if (settings.method == "POST") {
	  xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	  xhr.send(this.toQueryString(settings.data));
  } else {
	  xhr.send(null);  
  }
}

bitcamp.getJSON = function(url, success) {
  this.ajax(url, {
    method: "GET",
    dataType: "json",
    success: success
  });
}

bitcamp.post = function(url, data, success, dataType) {
  this.ajax(url, {
    method: "POST",
    data: data,
    success: success,
    dataType: dataType
  });
}

bitcamp.toQueryString = function(obj) {
	if (obj) {
		var queryString = "";
		for (var key in obj) {
			if (queryString != "")
				queryString += "&";
			queryString += key + "=" + obj[key] 
		}
		return queryString;
	}
	return null;
}




var $ = bitcamp;














