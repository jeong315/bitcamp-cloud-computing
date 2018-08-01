/**
 * 다른 개발자와 구별하려면 
 * 객체에 담는다.jQuery 만드는 중
 * 자주 사용할 함수를 라이브러리화 시킨다.
 */

"use strict"

//함수도 객체다
let bit = function(value){
    
    var el = [];//element List
    
    if(value instanceof HTMLElement){
        el[0] = value;
    }else if (value.startsWith('<')){
        el[0] = document.createElement(value.substr(1, value.length - 2));//subString(startIndex, endIndex), substr(start, length)
    } else{
        //여러개(한페이지에 3글)니까 querySelectAll 해줘야함
        var list = document.querySelectorAll(value);//얘가 리턴하는게 html collection
        // selector로 찾은 태그들을 빈 배열로 옮긴다.
        for(var i = 0; i < list.length ; i++){
            el[i] = list[i];
        }
    }
    //못찾았다 하더라도 빈 배열을 호출하기 위해 지워줌
//    if(el.length == 0) return null;//!e e가 존재하지 않으면
    
    //개발자가 쓰기 좋은 함수를 추가해서 리턴하자.
    el.html = function(value){
        if(arguments.length == 0){
            return el[0].innerHTML;
        }
        for(var e of el){
            e.innerHTML = value;
        }
        return el; 
    };
    
    el.append = function(child){
        for(var e of el){
            e.appendChild(child);
        }
        return e;
    };
    
    el.appendTo = function(parent){
        for(var e of el){
            
            parent[parent.length - 1 ].appendChild(e);
        }
        return el;
    };
    
    el.attr = function(name, value){
        if(arguments.length < 2){
            return el[0].getAttribute(name);
        }
        for(var e of el){
            e.setAttribute(name, value);            
        }
        return el;
    };
    
    el.removeAttr = function(name){
        for(var e of el){
            e.removeAttribute(name);            
        }
        return el;
    };
    
    el.on = function(name, p2, p3){//listener=handler서로 대체언어
        var selector = null;
        var handler = null;
        
        if(arguments.length == 2){
            handler = p2;
        }
        if(arguments.length == 3){
            selector = p2;
            handler = p3;
        }
      for(var e of el){
          if(!selector){
              //selector가 지정되어 있지 않으면
              //해당 태그에 대해 이벤트가 발생 했을 때 핸들러를 호출한다.
              e.addEventListener(name, handler);              
          }else{
              //selector가 지정되어 있으면,
              //핸들러를 호출하기 전에 selector에 해당하는 것인지 검사하는 
              //함수가 먼저 호출되게 한다. 
              e.addEventListener(name, function(event){
                  //'클릭 하는 시점'에 selector 태그를 찾는것.
                  //현재 태그의 자식 태그 중에서 selector 조건에 해당되는 자식 태그를 찾는다.
                 var selectorTargets = e.querySelectorAll(selector);
                 
                 //그 자식 태그들 중에 이 이벤트가 발생된 태그를 찾는다.
                 for (var target of selectorTargets){
                     //만약 이벤트가 발생된 태그와 일치하는 자식 태그가 있다면,
                     //그때서야 핸들러를 호출해준다.
                     if(event.target == target){
                         handler(event);
                         break;
                     }
                 }
              });
          }
          
          
      }
      return el;
    };
    
    el.click = function(handler){
        return el.on('click',handler);
    };
    //jQuery에 css 함수가 있다.
    el.css = function(name, value){
        if(arguments.length == 1){
            return el[0].style[name];
        }
        for(var e of el){
            e.style[name] = value;
        }
        return el;
    };
    
    el.val = function(value){
        if(arguments.length == 0){
            return el[0].value;
        }
        for( var e of el ){
            e.value = value;
        }
        return el;
    };
    
    return el;
    
};

 bit.parseQuery = function(url){
    var paramMap = {};
    
    var qs = url.split('?');
    
    if(qs.length > 1){
        var params = qs[1].split('&');
        
        for (var param of params){
            var kv = param.split('=');
            paramMap[kv[0]] = kv[1];
        }
    }
    return paramMap;
};

    bit.ajax = function(url, settings/*dataType, data, success 세개가 넘어온다.*/){
        
        if(settings == undefined){
            settings = {};
        }
        if(settings.dataType == undefined){
            settings.dataType = 'text';
        }
        if(settings.method == undefined){
            settings.method = 'GET';
            
            var xhr = new XMLHttpRequest();
            
            xhr.onreadystatechange = function() {
                if (xhr.readyState < 4) return;
                if (xhr.status !== 200) {
                    if(settings.error) 
                        error();
                    return;
                }
                let date = xhr.responseText;
                if(settings.dataType == 'json'){
                    data = JSON.parse(xhr.responseText);
                }
                if(settings.success){
                    settings.success(data);
                }    
              //done()에 의해 등록된 함수가 있다면 그 함수를 호출한다.
                if(done){ 
                    done(data);
                }
            };
            
            //settings에 서버로 보낼 데이터가 있다면 queryString으로 만든다.
            var qs = '';//queryString
            if(settings.data){
                for(var propName in settings.data){
                    qs += `&${propName}=${settings.data[propName]}`;
                }
            }
//            console.log(url);
            if(settings.method == 'GET'){
                
                if(url.indexOf('?') == -1)//?문자가 포함되지 않았다면 url뒤에다가 ?를 넣어라
                    url += '?';
                url += qs; // 물음표 뒤에 그리고 qs 붙여라
                xhr.open(settings.method , url, true);
                xhr.send();
            }else{
                xhr.open(settings.method, url , true);
                xhr.setRequestHeader('Content-Type', 
                'application/x-www-form-urlencoded');
                xhr.send(qs);
            }
            

            //XMLHttpRequest 객체를 리턴하기 전에 함수를 추가한다.
            let done;
            xhr.done = function(func){
                done = func;
            
        };
        return xhr;
    };
        
        bit.getJSON = function(url, p2, p3){//data, func 는 선택이다.
            let data = {};
            let success = null;
            
            if(arguments.length > 1){
            //기본 디폴트 값 세팅
                if(typeof p2 == "function") success = p2;           
//            if(typeof p2 != "function") data = p2;
                else data = p2;
                if(typeof p3 == "function") success = p3;
            }
        
            return bit.ajax(url, {
                dataType: 'json',
                data: data, //ajax에서 처리하려고
                success: success
            });
            
    };

        bit.post = function(url, p2, p3, p4){
            let data = {};
            let success = null;
            let dataType = 'text';
            
            if(arguments.length == 2){
                if(typeof p3 == "function"){
                    data = p2;
                    success = p3;
                }else if(typeof p2 == "function"){
                    success = p2;
                    dataType = p3;
                }else{
                    data = p2;
                    dataType = p3;
                } 
            } else if(arguments.length > 2){
                data = p2;
                success = p3;
                dataType = p4;
            }
        
            return bit.ajax(url, {
                method: 'POST',
                dataType: dataType,
                data: data, //ajax에서 처리하려고
                success: success
            });
            
    };

let $ = bit;//$특수문자가 아니라 문자로 자바스크립트에서만 쓸수 있따.(자바X)