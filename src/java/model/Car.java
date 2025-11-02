/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import jakarta.persistence.*;
@Entity @Table(name="cars")
/**
 *
 * @author PC
 */
public class Car {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String name;
  private String brand;
  private double pricePerDay;
  private boolean available;
  public Car() {}
  public Car(String name,String brand,double pricePerDay,boolean available){
    this.name=name;this.brand=brand;this.pricePerDay=pricePerDay;this.available=available;
  }
  // getters & setters ...
  public int getId(){return id;}
  public String getName(){return name;} public void setName(String n){this.name=n;}
  public String getBrand(){return brand;} public void setBrand(String b){this.brand=b;}
  public double getPricePerDay(){return pricePerDay;} public void setPricePerDay(double p){this.pricePerDay=p;}
  public boolean isAvailable(){return available;} public void setAvailable(boolean a){this.available=a;}
}
