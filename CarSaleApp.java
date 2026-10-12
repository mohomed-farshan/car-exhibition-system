import java.util.*;
abstract class Car{
	protected String model;
	protected int year;
	protected double originalPrice;
	
	Car(String model,int year,double originalPrice){
		this.model=model;
		this.year=year;
		this.originalPrice=originalPrice;
	}
	
	public int getYear(){
		return this.year;
	}
	public double getOriginalPrice(){
		return this.originalPrice;
	}
	public abstract double calculatePrice();
	public void displayDetails(){
		System.out.println("\nModel: "+this.model+"\nManufactured Year: "+this.year+"\nOriginal Price: "+this.originalPrice+"\nSale Price: "+calculatePrice()+"\n");
	}
	
}

class ClassicCar extends Car{
	ClassicCar(String model,int year,double originalPrice){
		super(model,year,originalPrice);
	}
	@Override
	public double calculatePrice(){
		return 100000.00;
	}
	
}

class SportsCar extends Car{
	
	SportsCar(String model,int year,double originalPrice){
		super(model,year,originalPrice);
	}
	
	@Override
	public double calculatePrice(){
		if(getYear()>2000){
			return 0.75*getOriginalPrice();
		}
		else if(getYear()>1995){
			return 0.5*getOriginalPrice();
		}
		else{
			return 0.25*getOriginalPrice();
		}
	}
	
}

class CarExhibition{
	private ArrayList <Car> cars;
	private String exhibitionName;
	
	CarExhibition(String exhibitionName){
		this.exhibitionName=exhibitionName;
		this.cars= new ArrayList<>();
	}
	
	public void addCar(Car c){
		cars.add(c);
	}
	
	public double getTotalPrice(){
		double grandTotal=0.0;
		for(Car c2: cars){
			grandTotal=grandTotal+c2.calculatePrice();
		}
		return grandTotal;	
	}
	
	public void displayExhibitionDetails(){
		System.out.println("\n===Exhibition: "+exhibitionName+" ===\n");
		for (Car c1: cars){
			c1.displayDetails();
		}
		
		System.out.println("\nTotal value of Cars in Exhibition: "+getTotalPrice()+"\n");
	}
}

public class CarSaleApp{
	public static void main(String args []){
		CarExhibition expo = new CarExhibition("Thotalaga Auto Expo");
		expo.addCar(new ClassicCar("Ford Mustang Boss 429",1969,45000.00));
		expo.addCar(new ClassicCar("Jaguar E-Type",1965,55000.00));
		
		expo.addCar(new SportsCar("Ferrari Enzo",2004,650000.00));
		expo.addCar(new SportsCar("Toyota Supra MK4",1998,80000.00));expo.addCar(new SportsCar("Porsche 911 Turbo",1992,120000.00));
		
		expo.displayExhibitionDetails();
	}
} 
