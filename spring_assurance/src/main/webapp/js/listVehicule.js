/*
$.post("http://localhost:8080/listVehicule", {"action":"modele", "marque":1, "modele":0, "chevaux":0},
    function( data ) {
        console.log( data.success );
        console.log( data.list );
    }, "json");
*/
/*$.ajax({
    url : 'http://localhost:8080/listVehicule',
    type : 'POST',
    headers : {'Content-Type':'application/json'},
    data : '{"action":"marque", "marque":0, "modele":0, "chevaux":0}',
    dataType : 'json',
    success : function(data, statut){
        console.log( data.success );
        console.log( data.list );
        if(data.success){
            $.each(data.list, function(index, item) {
                $('#brand').append($('<option>').text(item.name).val(item.id_marque));
            });
        }
    },
    error : function(resultat, statut, erreur){
        console.log("resultat !! "+resultat);
        console.log("statut !! "+statut);
        console.log("erreur !! "+erreur);
    }
});*/

sendList("marque", 0, 0, 0, recieveBrand);

function selectBrand (value){
    console.log("--- value : "+value);
    if(value) {
        sendList("modele", value, 0, 0, recieveModel);
    }
}

function sendList(action, valueBrand, valueModel, valueHorse, recieveJson){
    $.ajax({
        url: 'http://localhost:8080/listVehicule',
        type: 'POST',
        headers: {'Content-Type': 'application/json'},
        data: '{"action":"'+action+'", "marque":' + valueBrand + ', "modele":'+valueModel+', "chevaux":'+valueHorse+'}',
        dataType: 'json',
        success: function (data, statut) {
            console.log(data.success);
            console.log(data.list);
            $('#model').empty();
            $('#model').append($('<option>'));
            if (data.success) {
                recieveJson(data.list);
            }
        }
    });
}

function recieveBrand(json){
    $.each(json, function (index, item) {
        $('#brand').append($('<option>').text(item.name).val(item.id_marque));
    });
}

function recieveModel(json){
    $.each(json, function (index, item) {
        $('#model').append($('<option>').text(item.name).val(item.id_modele));
    });
}