package com.leandro.viagemais.entities;

// classe ainda vai ser usada...

public class Client {
  private int id;
  private String name;
  private String email;
  private String tel;
  private String passPort;
  private String cpf;

  // private usuario_id

  public Client(String name, String email, String tel, String passPort, String cpf) {
    this.name = name;
    this.email = email;
    this.tel = tel;
    this.passPort = passPort;
    this.cpf = cpf;
  }

  public Client() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getPassPort() {
    return passPort;
  }

  public void setPassPort(String passPort) {
    this.passPort = passPort;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}
