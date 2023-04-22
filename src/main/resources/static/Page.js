const socket = new WebSocket("ws://localhost:8080/app");
var flag;

function send(){
    var pln = document.getElementById("PLN").value;
    var gbp = document.getElementById("GPB").value;
    if((pln!="")&&(gbp=="")){
            Number(pln);
            if(!(isNaN(pln))){
                if(!(pln<0)){
                    flag=0;
                    socket.send("PLN".concat(pln));
                }else{
                    alert("Enter the positive number")
                }
            }else{
                alert("Enter the number")
            }
    }
    if((gbp!="")&&(pln=="")){
            Number(gbp);
            if(!(isNaN(gbp))) {
                if(!(gbp<0)){
                    flag=1;
                    socket.send("GBP".concat(gbp));
                }else{
                    alert("Enter the positive number")
                }
            }else{
                alert("Enter the number")
            }


    }

}


socket.onmessage = function(event) {
    if(flag==1){
        document.getElementById("PLN").value=event.data;
    }
    if(flag==0){
        document.getElementById("GPB").value=event.data;
    }
};

function onLoad(){
    $.ajax({
        url: "http://localhost:8080/GBPRate",
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            document.getElementById('actualRate').innerHTML="1 GBP = "+data+" PLN";
        }
    });
}

