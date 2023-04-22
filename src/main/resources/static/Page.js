const socket = new WebSocket("ws://localhost:8080/app");

function send(){
    var pln = document.getElementById("PLN").value;
    var gbp = document.getElementById("GPB").value;
    if((pln!="")&&(gbp=="")){
            Number(pln);
            if(!(isNaN(pln))){
                if(!(pln<0)){
                    socket.send(JSON.stringify({
                        amount: pln,
                        type:"PLN"
                    }));
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
                    socket.send(JSON.stringify({
                        amount: gbp,
                        type:"GBP"
                    }));
                }else{
                    alert("Enter the positive number")
                }
            }else{
                alert("Enter the number")
            }


    }

}


socket.onmessage = function(event) {
    var response = JSON.parse(event.data);

    if(response["type"]=='PLN'){
        document.getElementById("PLN").value=response["amount"] ;
    }

    if(response["type"]=='GBP'){
        document.getElementById("GPB").value=response["amount"] ;
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

