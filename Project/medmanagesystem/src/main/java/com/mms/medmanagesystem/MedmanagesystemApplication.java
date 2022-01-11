package com.mms.medmanagesystem;
import java.sql.Date;
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

@EnableRabbit
@SpringBootApplication 
public class MedmanagesystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
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
	
	
	@Override
	public void run(String... args) throws Exception { 

		if (areaService.getAreas().isEmpty()) {
			areaRepository.save(new Area(1, "Cardiologia"));
			areaRepository.save(new Area(2, "Cirugia I"));
			areaRepository.save(new Area(3, "Cirugia II"));
			areaRepository.save(new Area(4, "Dermatologia"));
			areaRepository.save(new Area(5, "Gastrenterologia"));
			areaRepository.save(new Area(6, "Ginecologia-Obstetrícia"));
			areaRepository.save(new Area(7, "Hematologia"));
			areaRepository.save(new Area(8, "Imagiologia"));
			areaRepository.save(new Area(9, "Imunoalergologia"));
			areaRepository.save(new Area(10, "Medicina Geral"));
			areaRepository.save(new Area(11, "Neurologia"));
			areaRepository.save(new Area(12, "Oncologia"));
			areaRepository.save(new Area(13, "Pediatria"));
			areaRepository.save(new Area(14, "Pneumologia"));
			areaRepository.save(new Area(15, "Psicologia"));
			areaRepository.save(new Area(16, "Psiquiatria"));
			
		}

		if (pessoaService.getPessoas().isEmpty()) {
			medicoRepository.save(new Medico(1,"7576664675766646", (new Pessoa(75766646, "Maia Mitchell", "maiamitchell@hotmail.com", 966265836, "153-5716 Odio, Rd", "21/10/1984")), areaRepository.getById(14)));
			medicoRepository.save(new Medico(2,"7385680573856805", (new Pessoa(73856805, "Leslie Landry", "leslielandry801@hotmail.com", 933236833, "Ap #744-1568 Luctus Street","10/12/1959" )), areaRepository.getById(2)));
			medicoRepository.save(new Medico(3,"6041232860412328", (new Pessoa(60412328, "Charles Morris", "charlesmorris@google.com", 914721284, "963-7884 Ipsum St.","20/03/1960" )), areaRepository.getById(5)));
			medicoRepository.save(new Medico(4,"4426569644265696", (new Pessoa(44265696, "Inês Carvalho Almeida", "inesalmeida@hotmail.com", 933236833, "963-7884 Ipsum St","10/12/1980" )), areaRepository.getById(13)));
			medicoRepository.save(new Medico(5,"6758685967586859", (new Pessoa(73856805, "Brandon Foster", "brandon_foster@google.com", 962222898, "2040 Penatibus Av.","07/05/1995" )), areaRepository.getById(2)));


			pacienteRepository.save(new Paciente(1, (new Pessoa(83664712, "Miguel dos Santos", "miguelds@outlook.com", 914415566, "331-3048 Sodales. Rd", "20/03/1982")), consultaService.getAllConsultasById(consultaRepository.getById(1), consultaRepository.getById(2)), internamentoRepository.getById(1));
		}

		if (consultaService.getConsultas().isEmpty()) {
			consultaRepository.save(new Consulta(1, pessoaRepository.getById(1), medicoRepository.getById(1), "Queixas a fazer exercício físico", Date.valueOf("2001-5-20"), ""));
		}
	
	}

}

