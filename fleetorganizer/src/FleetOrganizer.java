
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;


/**
 * A testbed for the Heap implementation; sorts car data in various orders
 * @see HeapAPI.java, CarAPI.java
 * @author Bellaire, Miles
 * <pre>
 * File: FleetOrganizer.cpp
 * Date: 10-4-21
 * Programming Project # 1
 * Instructor: Dr. Duncan 
 * 
 * Usage: FleetOrganizer <data-file> <order-key>
 * Note: Record for the vehicles must be organized in the data text file with 
 *       records, one per row, and with fields comma-delimited, as follows:
 *       <year>, <make>, <model>, <type>
 * 
 * DO NOT REMOVE THIS NOTICE (GNU GPL V2):
 * Contact Information: duncan@csc.lsu.edu
 * Copyright (c) 2021 William E. Duncan
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>
 * </pre>
 */
public class FleetOrganizer 
{
    public static void main(String[] args) throws IOException, HeapException
    {
        String usage = "FleetOrganizer <data-file> <order-key>\n";
        usage += "Record for the vehicles must be organized in the data file with records, one per row,\n";
        usage +=  "and with fields comma-delimited, as follows:\n";
        usage += "<year>,<make>,<model>,<type>\n";
        //complete implementation of this function   
		
		Scanner inFile = new Scanner(new FileReader("vehicles.txt")); 
		Scanner in = new Scanner(System.in);
		String[] responses = new String[] {"-make-model-type-year", "-year-make-mode-type", "-type+year-make-model", "+year+make+model+type", "+make+model+type+year"};
		Comparator<Car> ctrl;
		Heap<Car> cars;
		int input;
		
		System.out.println("Enter how you would like to sort the cars: ");
		input = in.nextInt() + 2;
		in.close();
		System.out.println("Fleet: " + responses[input]);
		
		ctrl = (car1,car2) ->
		{
			return car1.compareTo(car2);
		};
		
		if(input == 0)
		ctrl = (car1,car2) ->
		{
			if(car1.getMake().compareTo(car2.getMake()) == 0) {
				if(car1.getModel().compareTo(car2.getModel()) == 0) {
					if(car1.getType().compareTo(car2.getType()) == 0) {
						if(car1.getYear() < car2.getYear()) return 1;
						else return -1;
					}	
					return car1.getType().compareTo(car2.getType());
				}
				return car1.getModel().compareTo(car2.getModel());
			}
			return car1.getMake().compareTo(car2.getMake());
		};
		else if(input == 2)
			ctrl = (car1,car2) ->
			{
				if(car1.getType().compareTo(car2.getType()) == 0) {
					if(car1.getYear() == car2.getYear()) {
						if(car1.getMake().compareTo(car2.getMake()) == 0) {
							return car1.getModel().compareTo(car2.getModel());
						}
						return car1.getMake().compareTo(car2.getMake());
					}
					if(car1.getYear() < car2.getYear()) return 1;
					else return -1;
				}
				return car1.getType().compareTo(car2.getType());
			};
		else if(input == 3)
			ctrl = (car1,car2) ->
			{
				return -car1.compareTo(car2);
			};
		else if(input == 4)
			ctrl = (car1,car2) ->
				{
					if(car1.getMake().compareTo(car2.getMake()) == 0) {
						if(car1.getModel().compareTo(car2.getModel()) == 0) {
							if(car1.getType().compareTo(car2.getType()) == 0) {
								if(car1.getYear() < car2.getYear()) return 1;
								else return -1;
							}	
							return -1*car1.getType().compareTo(car2.getType());
						}
						return -1*car1.getModel().compareTo(car2.getModel());
					}
					return -1*car1.getMake().compareTo(car2.getMake());
				};
		

		cars = new Heap<Car>(ctrl);
	
		while(inFile.hasNextLine()) {
			String[] stats = inFile.nextLine().split(",");
			cars.insert(new Car(Integer.parseInt(stats[0]), stats[1].toUpperCase(), stats[2].toUpperCase(), stats[3].toUpperCase()));
		}
	
		inFile.close();
		
		while(!cars.isEmpty()) 
			System.out.println(cars.remove().toString());
    }    
}
