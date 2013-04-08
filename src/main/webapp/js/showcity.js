function tanchu(anchor){
	/*$("span[id$='span']").each(function(){
			$(this).css("display","none");
		}
	);*/

	textinput = $(anchor).prev();
    var citylistarr = [];
    var position = $(anchor).position();
    var tc = document.getElementById('tanchu');
    var as = tc.getElementsByTagName("a");
    for(var i=0; i<as.length; i++)
    {
        as[i].onclick = function()
        {
            var a = i;
            return function()
            {
               // textinput.value = $(as[a]).attr("code");//0机场 1城市
               //hide_city();
				textinput.val($(as[a]).attr("code"));
				var nextli = $(anchor).closest("li").nextAll("li:first");
				var nextinputval = nextli.find("input[name=desinationcode]").val();
				if(textinput.attr("name") == "origincode" && (nextinputval == "城市名" || nextinputval == "")) {
					var nextanchor_to = nextli.find("span[name=tanchu]");
					nextanchor_to.click();
				} else {
					hide_city();
				}
            };
        }(i);
    }
	if(!$.browser.msie || $.browser.msie && $.browser.version == '10.0'){
        tc.style.left = parseInt(position['x'] - 160) + 'px';
        tc.style.top = parseInt(position['y'] + 20) + 'px';
    }
	if(!$.browser.msie || $.browser.msie && $.browser.version == '9.0'){
        tc.style.left = parseInt(position['x'] - 160) + 'px';
        tc.style.top = parseInt(position['y'] + 20) + 'px';
    }
    if(!$.browser.msie || $.browser.msie && $.browser.version == '8.0'){
        tc.style.left = parseInt(position['x'] - 160) + 'px';
        tc.style.top = parseInt(position['y'] + 20) + 'px';
    }
    else if($.browser.msie && $.browser.version == '6.0'){
        tc.style.left = parseInt(position['x'] - 160) + 'px';
        tc.style.top = parseInt(position['y'] + 23) + 'px';
    }
    else if($.browser.msie && $.browser.version == '7.0'){
        tc.style.left = parseInt(position['x'] - 160) + 'px';
        tc.style.top = parseInt(position['y'] + 23) + 'px';
    }
    if($(anchor).attr("type") == "intl_from"){
    	go_domestic();
    }else if($(anchor).attr("type") == "intl_to")
    {
    	go_abroad();
    }
    tc.style.display = 'block';
}
function hide_city()
{
    document.getElementById('tanchu').style.display = 'none';
    //document.getElementById("price").style.display = '';
}
function getposition(obj)
{
    var r = new Array();
    r['x'] = obj.offsetLeft;
    r['y'] = obj.offsetTop;
    while(obj = obj.offsetParent)
    {
        r['x'] += obj.offsetLeft;
        r['y'] += obj.offsetTop;
    }
    return r;
}	    
/*切换到国内*/
function go_domestic() 
	{			 		  
		document.getElementById("hotcity_domestic").className="on";
		document.getElementById("hotcity_abroad").className="mr2";
		document.getElementById("dom_city_cont").style.display='block';
		document.getElementById("abr_city_cont").style.display='none';
	}
	
/*切换到国外*/	
function go_abroad() 
	{						 
		document.getElementById("hotcity_domestic").className="mr2";
		document.getElementById("hotcity_abroad").className="on";
		document.getElementById("abr_city_cont").style.display='block';
		document.getElementById("dom_city_cont").style.display='none';
	}    

$(function() {
$(document).ready(function(){ 



//document.onclick=function(e){
//	e = window.event || e;
//    var srcElement = e.srcElement || e.target;
//	var cale= document.getElementById("calendar-1");
//  	if(srcElement.id=="calendar-1" || (srcElement.id!="FromDate1" &&srcElement.id!="FromDate2" && cale.style.display!="block")) ;
//  	else{
//	  	if(cale.style.display!="block")
//	      	cale.style.display="block";
//	  	else
//	      	cale.style.display="none";
//  	}
//    if($(srcElement).attr("id")=="tanchu" || $(srcElement).attr("name")=="tanchu") ;
//    else{
//    	hide_city();
//    }
//}
//新增
document.onclick = function(e) {
			e = window.event || e;
			var srcElement = e.srcElement || e.target;
			var cale = document.getElementById("calendar-1");
			if($(srcElement).parents("#calendar-1").length == 1 || srcElement.id == "FromDate1" || srcElement.id == "FromDate2" || srcElement.id == "FromDate3" || srcElement.id == "returnDate") {

			} else {
				cale.style.display = "none";
			}
			if($(srcElement).parents("#tanchu").length == 1 || $(srcElement).attr("id") == "tanchu" || $(srcElement).attr("name") == "tanchu") {
				
			} else if($(srcElement).attr("name")=="origincode" || $(srcElement).attr("name")=="desinationcode"){
				tanchu($(srcElement).next()[0]);
			}else{
				hide_city();
			}
		};


$("ul.paytabmenu2 li:first-child").addClass("cur2"); 
$("div.paytabcontent2").find("div.lay2:not(:first-child)").hide(); 
$("div.paytabcontent2 div.lay2").attr("id", function(){return idNumber("Noo")+ $("div.paytabcontent2 div.lay2").index(this)}); 
$("ul.paytabmenu2 li").mouseover(function(){ 
var c = $("ul.paytabmenu2 li"); 
var index = c.index(this); 
var p = idNumber("Noo"); 
showtab(c,index,p); 
}); 
function showtab(controlMenu,num,prefix){ 
var paytabcontent= prefix + num; 
$('#'+ paytabcontent).siblings().hide(); 
$('#'+ paytabcontent).show(); 
controlMenu.eq(num).addClass("cur2").siblings().removeClass("cur2"); 
}; 
function idNumber(prefix){ 
var idNum = prefix; 
return idNum; 
}
}); 
});