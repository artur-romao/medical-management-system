package com.mms.medmanagesystem.messageBroker;
 
import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Paciente;
import com.mms.medmanagesystem.service.PacienteService;

 

public class Getter {
     

     
    private PacienteService getPacienteService(){

        return SpringContext.getBean(PacienteService.class);
    }

    public String infoPac(String message) throws ResourceNotFoundException{

        Paciente paciente=getPacienteService().getPacienteById(1);

        if(paciente==null){

            return "";
        }
        message = "<" + paciente.getCc() + "> "+message;
        
        
        return message;

    }

}
