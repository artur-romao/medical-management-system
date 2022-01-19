async function getData(url){
    const response = await fetch(url);
    var data = await response.json();
    console.log(data)
    
    show_data(data, url);
}


function show_data(data){
    var list;
    if (data.length <= 1)
        list = data;
    else
        list = data.list;
    var type = [];
    var tab = ``;
    for (let i = 0; i < data.length; i++) {

    }
    //document.getElementById("classes").innerHTML = tab;
}

