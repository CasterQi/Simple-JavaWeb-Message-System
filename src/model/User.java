package model;


public class User{

  private  String username;
  private  String password;
  private  String verifyCode;
  private  String age;
  private  String gender;


  public String getUsername(){
    return username;
  }

  public void setUsername(String username){
    this.username = username;
  }

  public String getPassword(){
    return password;
  }

  public void setPassword(String password){
    this.password = password;
  }

  public String getVerifyCode(){
    return verifyCode;
  }

  public void setVerifyCode(String verifyCode){
    this.verifyCode = verifyCode;
  }

  public String getAge(){
    return age;
  }

  public void setAge(String age){
    this.age = age;
  }

  public String getGender(){
    return gender;
  }

  public void setGender(String gender){
    this.gender = gender;
  }


}
