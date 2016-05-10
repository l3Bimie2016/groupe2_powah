
var brandSelected, modelSelected, horseSelected;

sendList("marque", 0, 0, 0, recieveBrand);

function selectBrand (value){
    brandSelected = value;
    emptySelect("#model"); emptySelect("#fiscal_horse_power"); emptySelect("#type_fuel");
    if(value) sendList("modele", brandSelected, 0, 0, recieveModel);
}
function selectModel (value){
    modelSelected = value;
    emptySelect("#fiscal_horse_power"); emptySelect("#type_fuel");
    if(value) sendList("chevaux", brandSelected, modelSelected, 0, recieveHorse);
}
function selectHorse (value){
    horseSelected = value;
    emptySelect("#type_fuel");
    if(value) sendList("carburant", brandSelected, modelSelected, horseSelected, recieveFuel);
}

function sendList(action, valueBrand, valueModel, valueHorse, recieveJson){
    $.ajax({
        url: 'http://localhost:8080/listVehicule',
        type: 'POST',
        headers: {'Content-Type': 'application/json'},
        data: '{"action":"'+action+'", "marque":' + valueBrand + ', "modele":'+valueModel+', "chevaux":'+valueHorse+'}',
        dataType: 'json',
        success: function (data, statut) {
            if (data.success) recieveJson(data.list);
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

function recieveHorse(json){
    $.each(json, function (index, item) {
        $('#fiscal_horse_power').append($('<option>').text(item.name).val(item.id_chevaux_fiscaux));
    });
}

function recieveFuel(json){
    $.each(json, function (index, item) {
        $('#type_fuel').append($('<option>').text(item.name).val(item.id_carburant));
    });
}

function emptySelect(name){
    $(name).empty();
    $(name).append($('<option>'));
}