package com.mms.medmanagesystem;
import com.mms.medmanagesystem.enumFolder.EstadoEnum;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;

import javax.transaction.Transactional;

import com.mms.medmanagesystem.service.*;
import com.mms.medmanagesystem.model.*;
import com.mms.medmanagesystem.repository.*;

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
	@Autowired private ConsultaRepository consultaRepository;
	@Autowired private InternamentoRepository internamentoRepository;
	@Autowired private MedicoRepository medicoRepository;
	@Autowired private PacienteRepository pacienteRepository;
	@Autowired private PessoaRepository pessoaRepository;
	@Autowired private AreaService areaService;
	@Autowired private PessoaService pessoaService;
	@Autowired private MedicoService medicoService;
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

		}
		
		if (pessoaService.getPessoas().isEmpty()) {

			medicoService.saveMedico(new Medico("7576664675766646", (new Pessoa(75766646, "Maia Mitchell", "maiamitchell@hotmail.com", 966265836, "153-5716 Odio, Rd", "21101984")), areaRepository.getById(14)));
			medicoService.saveMedico(new Medico("7385680573856805", (new Pessoa(73856805, "Leslie Landry", "leslielandry801@hotmail.com", 933236833, "Ap #744-1568 Luctus Street","10/12/1959" )), areaRepository.getById(2)));
			medicoService.saveMedico(new Medico("6041232860412328", (new Pessoa(60412328, "Charles Morris", "charlesmorris@google.com", 914721284, "963-7884 Ipsum St.","20/03/1960" )), areaRepository.getById(5)));
			medicoService.saveMedico(new Medico("4426569644265696", (new Pessoa(44265696, "Inês Carvalho Almeida", "inesalmeida@hotmail.com", 933236833, "963-7884 Ipsum St","10/12/1980" )), areaRepository.getById(13)));
			medicoService.saveMedico(new Medico("6758685967586859", (new Pessoa(73856705, "Brandon Foster", "brandon_foster@google.com", 962222898, "2040 Penatibus Av.","07/05/1995" )), areaRepository.getById(2)));

			pacienteService.savePaciente(new Paciente((new Pessoa(83664712, "Miguel dos Santos", "miguelds@outlook.com", 914415566, "331-3048 Sodales. Rd", "20/03/1982"))));
			pacienteService.savePaciente(new Paciente((new Pessoa(14151414, "Ana Maria", "anamaria@outlook.com", 965147826, "Alameda 29 Aveiro,12", "10/03/2000"))));
			
			consultaService.saveConsulta(new Consulta(pacienteRepository.getById(1), medicoRepository.getById(1), "Queixas a fazer exercício físico", Date.valueOf("2020-05-20"), ""));
			consultaService.saveConsulta(new Consulta(pacienteRepository.getById(1), medicoRepository.getById(3), "Apendicite", Date.valueOf("2021-01-02"), "Pois é"));
			
			// ASSIM DÁ TUDO NO MESMO
				internamentoService.saveInternamento(new Internamento(pacienteRepository.getById(1), medicoRepository.getById(1),(float)0, (new Double[500]), (new Float[10]), (float)0, "Apendicite","2A", EstadoEnum.ESTAVEL.toString(), Date.valueOf("2021-5-20"),Date.valueOf("2022-5-20"), new int[4]));
				internamentoService.saveInternamento(new Internamento(pacienteRepository.getById(2), medicoRepository.getById(3),(float)0, (new Double[500]), (new Float[10]), (float)0, "Apendicite","2B", EstadoEnum.GRAVE.toString(), Date.valueOf("2021-5-22"),Date.valueOf("2022-5-22"), new int[4]));
				
			// OU ASSIM
			// internamentoService.saveInternamento(new Internamento(pacienteRepository.getById(1), medicoRepository.getById(1)));
			// internamentoService.saveInternamento(new Internamento(pacienteRepository.getById(2), medicoRepository.getById(3)));
			

			// Internamento i1 = internamentoService.saveInternamento(new Internamento(pacienteRepository.getById(1), medicoRepository.getById(1), "Apendicite","2A","estável",Date.valueOf("2021-5-20"),Date.valueOf("2022-5-20")));
			// Internamento i2 = internamentoService.saveInternamento(new Internamento(pacienteRepository.getById(2), medicoRepository.getById(1), "Apendicite","2B","instável",Date.valueOf("2021-5-22"),Date.valueOf("2022-5-22")));

			// i1.setOxigenio((float)0);
			// i1.setPressaoarterial(new Float[10]);
			// i1.setPulso(new Double[10]);

			// i2.setOxigenio((float)0);
			// i2.setPressaoarterial(new Float[10]);
			// i2.setPulso(new Double[10]);
		
			
			// pacienteService.updatePacienteCI(pacienteRepository.getById(1), consultaService.getAllConsultasById(1,2), internamentoService.getAllInternamentosById(1));
			// pacienteService.updatePacienteCI(pacienteRepository.getById(2), consultaService.getAllConsultasById(2), internamentoService.getAllInternamentosById(2));
		

		}
		

	}

}

