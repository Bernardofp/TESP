package br.unibh.escola.entidades;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "cpf"), name = "TB_PESSOA")
public abstract class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min=5, max =100)
	@Column(length = 100, nullable = false, columnDefinition = "VARCHAR(100)")
	@Pattern(regexp = "[A-Za-zÀ-ú ]*", message = "deve conter apenas caracteres e acentos!")
	private String nome;
	
	@NotBlank
	@Size(min=14, max=14)	
	@Pattern(regexp="\\(\\d{3}\\).\\d{3}\\).\\d{3}-\\d{2}")
	@Column(length = 14, nullable = false, columnDefinition = "CHAR(14)")
	private String cpf;
	
	public Pessoa(Long id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
	}
	

	
	
}
