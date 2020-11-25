package com.example.demo.model;

public class Aluno {
	
	private String nome;
	private String RA;
	private double nota1;
	private double nota2;
	private double media;
	
	public Aluno() { }
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRA() {
		return RA;
	}
	public void setRA(String rA) {
		RA = rA;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", RA=" + RA + ", nota1=" + nota1 + ", nota2=" + nota2 + ", media=" + media
				+ "]";
	}
	
}
