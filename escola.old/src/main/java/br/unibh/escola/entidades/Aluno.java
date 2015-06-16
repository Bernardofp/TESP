package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


@Entity @PrimaryKeyJoinColumn
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "matricula"), name = "TB_ALUNO")
public class Aluno extends Pessoa {
	
	@NotBlank
	@Size(min = 8, max = 8)
	@Pattern(regexp = "[0-9]*", message = "deve conter somente numeros!")
	@Column(unique=true, nullable=false)
	private Long matricula;
	
	@NotNull
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataAniversario;
	
	public Aluno(Long id, Long matricula, String nome, String cpf, Date dataAniversario) {
		super(id, nome, cpf);
		this.matricula = matricula;
		this.dataAniversario = dataAniversario;
	}
	
	public Aluno(Long id, Long matricula, String nome, String cpf) {
		super(id, nome, cpf);
		this.matricula = matricula;

	}
	
	public Aluno(Long id, Long matricula, String nome) {
		super(id, nome, null);
		this.matricula = matricula;
	}
	
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public Date getDataAniversario() {
		return dataAniversario;
	}
	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	@Override
	public String toString() {
		return "Aluno [dataAniversario=" + dataAniversario + ", matricula="
				+ matricula + "]"
				+ super.toString();
	}


	public static Boolean verificaMatricula(String matricula){
		if (matricula == null){
			return false;
		} else if (matricula.trim().equals("")) {
			return false;
		} else if (matricula.length() != 8){
			return false;
		} else {
			return true;
		}
		
	}
	

}
