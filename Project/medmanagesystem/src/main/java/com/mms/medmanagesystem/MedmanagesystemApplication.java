package com.mms.medmanagesystem;
import com.mms.medmanagesystem.enumFolder.EstadoEnum;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;

import javax.transaction.Transactional;

import com.mms.medmanagesystem.service.*;
import com.mms.medmanagesystem.model.*;
import com.mms.medmanagesystem.repository.*;
import com.mms.medmanagesystem.enumFolder.*;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableRabbit
@SpringBootApplication 
public class MedmanagesystemApplication implements CommandLineRunner {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MedmanagesystemApplication.class, args);
	}

	
	@Autowired private AreaRepository areaRepository;
	@Autowired private ProfissionalRepository profissionalRepository;
	@Autowired private PacienteRepository pacienteRepository;
	@Autowired private AreaService areaService;
	@Autowired private PessoaService pessoaService;
	@Autowired private ProfissionalService profissionalService;
	@Autowired private ConsultaService consultaService;
	@Autowired private InternamentoService internamentoService;
	@Autowired private PacienteService pacienteService;

	
	
	@Override
	public void run(String... args) throws Exception { 

		if (areaService.getAreas().isEmpty()) {
			areaService.saveArea(new Area("Cardiologia"));
			areaService.saveArea(new Area("Cirugia I"));
			areaService.saveArea(new Area("Cirugia II"));
			areaService.saveArea(new Area("Dermatologia"));
			areaService.saveArea(new Area("Gastrenterologia"));
			areaService.saveArea(new Area("Ginecologia-Obstetrícia"));
			areaService.saveArea(new Area("Hematologia"));
			areaService.saveArea(new Area("Imagiologia"));
			areaService.saveArea(new Area("Imunoalergologia"));
			areaService.saveArea(new Area("Medicina Geral"));
			areaService.saveArea(new Area("Neurologia"));
			areaService.saveArea(new Area("Oncologia"));
			areaService.saveArea(new Area("Pediatria"));
			areaService.saveArea(new Area("Pneumologia"));
			areaService.saveArea(new Area("Psicologia"));
			areaService.saveArea(new Area("Psiquiatria"));
			areaService.saveArea(new Area("Geral"));

		}
		
		if (pessoaService.getPessoas().isEmpty()) {

			// Medicos
			profissionalService.saveProfissional(new Profissional("7576664675766646", (new Pessoa(75766646, "Maia Mitchell", "maiamitchell@hotmail.com", 966265836, "153-5716 Odio, Rd", "21/10/1984")), areaRepository.getById(14),ProfissionalEnum.MEDICO.toString()));
			profissionalService.saveProfissional(new Profissional("7385680573856805", (new Pessoa(73856805, "Leslie Landry", "leslielandry801@hotmail.com", 933236833, "Ap #744-1568 Luctus Street","10/12/1959" )), areaRepository.getById(2), ProfissionalEnum.MEDICO.toString()));
			profissionalService.saveProfissional(new Profissional("4426569644265696", (new Pessoa(44265696, "Inês Carvalho Almeida", "inesalmeida@hotmail.com", 933236833, "963-7884 Ipsum St","10/12/1980" )), areaRepository.getById(13), ProfissionalEnum.MEDICO.toString()));
			profissionalService.saveProfissional(new Profissional("7385670573856705", (new Pessoa(73856705, "Brandon Foster", "brandon_foster@google.com", 962222898, "2040 Penatibus Av.","07/05/1995" )), areaRepository.getById(2), ProfissionalEnum.MEDICO.toString()));
			profissionalService.saveProfissional(new Profissional("7381230573812305", (new Pessoa(73812305, "Alexandra Dominguez", "alexandradominguez7380@google.com", 921622641, "5626 Magna. Street","22/11/1978" )), areaRepository.getById(4), ProfissionalEnum.MEDICO.toString()));
			
			// Enfermeiros
			profissionalService.saveProfissional(new Profissional("6041147860411478", (new Pessoa(60411478, "Max Waldo", "waldowino@google.com", 914721284, "Rua Professor Egas Moniz nº 12","07/08/1996" )), areaRepository.getById(17), ProfissionalEnum.ENFERMEIRO.toString()));
			
			// Pacientes
			pacienteService.savePaciente(new Paciente((new Pessoa(83664712, "Miguel dos Santos", "miguelds@outlook.com", 914415566, "331-3048 Sodales. Rd", "20/03/1982"))));
			pacienteService.savePaciente(new Paciente((new Pessoa(14151414, "Ana Maria", "anamaria@outlook.com", 965147826, "Alameda 29 Aveiro,12", "10/03/2000"))));
			pacienteService.savePaciente(new Paciente((new Pessoa(70180323, "Leslie Landry", "leslielandry801@hotmail.com", 933236833, "5626 Magna. Street", "10/12/1959"))));
			pacienteService.savePaciente(new Paciente((new Pessoa(60412328, "Cally Crosby", "callycrosby3755@google.com", 964187242, "Ap #108-4396 Vel Av.", "18/03/1965"))));
			pacienteService.savePaciente(new Paciente((new Pessoa(44265123, "Charles Morris", "charlesmorris@google.com", 914721284, "865-1262 Scelerisque Av.", "10/05/1996"))));
			pacienteService.savePaciente(new Paciente((new Pessoa(16914043, "Christen Bailey", "christenbailey2208@google.com", 928812722, "P.O. Box 120, 8950 Lorem Ave", "01/05/1937"))));
			pacienteService.savePaciente(new Paciente((new Pessoa(36532406, "Armand Wallace", "", 924521672, "Ap #439-4538 Pellentesque Rd.", "03/08/2018"))));
			pacienteService.savePaciente(new Paciente((new Pessoa(14834664, "Kim Blackburn", "anamaria@outlook.com", 965147826, "4607 Interdum. Road", "01/12/2001"))));
			pacienteService.savePaciente(new Paciente((new Pessoa(33669801, "Rajah Perez", "rajahperez8664@hotmail.com", 921374999, "Ap #583-1825 Ut Avenue", "05/07/1960"))));
			pacienteService.savePaciente(new Paciente((new Pessoa(53091699, "Philip Stevenson ", "", 965147826, "1189 Lorem, Road", "06/04/2019"))));
			pacienteService.savePaciente(new Paciente((new Pessoa(87845555, "Brianna Davenport ", "yvettereeves1649@hotmail.com", 965147826, "P.O. Box 868, 5015 Mauris. St.", "20/01/1993"))));
			pacienteService.savePaciente(new Paciente((new Pessoa(40882324, "Hayley Ellison ", "hayleyellison@google.com", 927699778, "Ap #261-3437 Montes, Street", "16/11/1960"))));

			// Consultas
			consultaService.saveConsulta(new Consulta(pacienteRepository.getById(1), profissionalRepository.getById(1), "Queixas a fazer exercício físico", Date.valueOf("2020-05-20"), ""));
			consultaService.saveConsulta(new Consulta(pacienteRepository.getById(2), profissionalRepository.getById(2), "Apendicite", Date.valueOf("2021-12-02"), "Em estado crítico."));
			consultaService.saveConsulta(new Consulta(pacienteRepository.getById(3), profissionalRepository.getById(1), "Asma crítica", Date.valueOf("2021-06-15"), ""));
			consultaService.saveConsulta(new Consulta(pacienteRepository.getById(4), profissionalRepository.getById(1), "Transplante de rim", Date.valueOf("2022-01-01"), "Rim direito em falência"));
			consultaService.saveConsulta(new Consulta(pacienteRepository.getById(10), profissionalRepository.getById(3), "Varicela", Date.valueOf("2021-11-07"), ""));
			consultaService.saveConsulta(new Consulta(pacienteRepository.getById(6), profissionalRepository.getById(3), "Dores de estômago diárias", Date.valueOf("2021-04-04"), ""));
			consultaService.saveConsulta(new Consulta(pacienteRepository.getById(7), profissionalRepository.getById(3), "Raio-X ao pé direito", Date.valueOf("2021-09-27"), ""));
			consultaService.saveConsulta(new Consulta(pacienteRepository.getById(8), profissionalRepository.getById(1), "Dificuldades a respirar - COVID19", Date.valueOf("2022-01-10"), "Complicações nos pulmoões"));

			// Internamentos
			internamentoService.saveInternamento(new Internamento(pacienteRepository.getById(1), profissionalRepository.getById(1),(float)0, (new Double[10]), (new Float[10]), (float)0, "Queimaduras no corpo 3º grau","2A", EstadoEnum.GRAVE.toString(), Date.valueOf("2021-5-20"),Date.valueOf("2022-5-20"), new int[4]));
			internamentoService.saveInternamento(new Internamento(pacienteRepository.getById(2), profissionalRepository.getById(3),(float)0, (new Double[10]), (new Float[10]), (float)0, "Apendicite","2B", EstadoEnum.ESTAVEL.toString(), Date.valueOf("2021-5-22"),Date.valueOf("2022-5-22"), new int[4]));
			
			// OU ASSIM
			// internamentoService.saveInternamento(new Internamento(pacienteRepository.getById(1), medicoRepository.getById(1)));
			// internamentoService.saveInternamento(new Internamento(pacienteRepository.getById(2), medicoRepository.getById(3)));
			

			// Internamento i1 = internamentoService.saveInternamento(new Internamento(pacienteRepository.getById(1), medicoRepository.getById(1), "Apendicite","2A","estável",Date.valueOf("2021-5-20"),Date.valueOf("2022-5-20")));
			// Internamento i2 = internamentoService.saveInternamento(new Internamento(pacienteRepository.getById(2), medicoRepository.getById(1), "Apendicite","2B","instável",Date.valueOf("2021-5-22"),Date.valueOf("2022-5-22")));

			// i1.setOxigenio((float)0);
			// i1.setpressaoarterial(new Float[10]);
			// i1.setPulso(new Double[10]);

			// i2.setOxigenio((float)0);
			// i2.setpressaoarterial(new Float[10]);
			// i2.setPulso(new Double[10]);
		
			
			// pacienteService.updatePacienteCI(pacienteRepository.getById(1), consultaService.getAllConsultasById(1,2), internamentoService.getAllInternamentosById(1));
			// pacienteService.updatePacienteCI(pacienteRepository.getById(2), consultaService.getAllConsultasById(2), internamentoService.getAllInternamentosById(2));
		

		}
		

	}

}

