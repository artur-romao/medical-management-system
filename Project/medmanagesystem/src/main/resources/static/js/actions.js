function filterFunction(value,data) {
    var filteredData = [];
    for (var i=0; i<data.length; i++) {
        var name = data[i].name.toLowerCase();
        
        if (name.includes(value)) {
            filteredData.push(data[i]);

        }
        //alert("Here's the name: " + name + "and number ");
        //some testings
    }
    return filteredData;
}

function rebuildTable(data) {
    var table = document.getElementById('patientTable')
    table.innerHTML=''
    for (var i=0; i<data.length; i++) {
        row= 
            `<tr>
                            <td> [[${patient.paciente.nome}]]</td>
                <td> [[${patient.paciente.pessoacc}]]</td>
                            <td> [[${patient.paciente.email}]]</td>
                            <td> [[${patient.paciente.telemovel}]]</td>
                <td> [[${patient.paciente.morada}]]</td>
                <td> [[${patient.paciente.datanascimento}]]</td>



                
                <td>
                    <a href="#editPacienteModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                    <a href="#deletePacienteModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                </td>
            </tr>`
            table.innerHTML += row

            
            
            
    }
}