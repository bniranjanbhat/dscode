package com.code.generics;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class AnimalDoctor {
// method takes an array of any animal subtype
	public void checkAnimals(Animal[] animals) {
		for (Animal a : animals) {
			a.checkup();
		}
	}

	public static void main(String[] args) {
// test it
		Dog[] dogs = { new Dog(), new Dog() };
		Cat[] cats = { new Cat(), new Cat(), new Cat() };
		Bird[] birds = { new Bird() };
		AnimalDoctor doc = new AnimalDoctor();
		doc.checkAnimals(dogs); // pass the Dog[]
		doc.checkAnimals(cats); // pass the Cat[]
		doc.checkAnimals(birds); // pass the Bird[]
		
		 
		
	}
}