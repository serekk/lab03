package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //zadanie 1
        Set <String> daysOfTheWeek = new TreeSet<>();

        daysOfTheWeek.add("monday");
        daysOfTheWeek.add("tuesday");
        daysOfTheWeek.add("wednesday");
        daysOfTheWeek.add("thursday");
        daysOfTheWeek.add("friday");
        daysOfTheWeek.add("saturday");
        daysOfTheWeek.add("sunday");

        System.out.println(daysOfTheWeek);

        //zadanie 2
        Teacher mkramarczyk = new Teacher("Michał", "Kramarczyk", "mkramarczyk@wi.zut.edu.pl",
                "Technologie programowania systemów internetowych");
        Teacher gsliwinski = new Teacher("Grzegorz", "Śliwiński",
                "gsliwinski@zut.edu.pl", "Infrastruktura Internetu i usługi sieciowe" );

        Map<String, Teacher> courses = new HashMap<>();

        courses.put("Programowanie obiektowe", mkramarczyk);
        courses.put("Infrastruktura Internetu i usługi sieciowe", gsliwinski);

        System.out.println(courses.get("Programowanie obiektowe"));

        List<Student> group32 = new ArrayList<>();
        group32.add(new Student("Zenon", "Martyniuk", "mz978343@zut.edu.pl","32"));
        group32.add(new Student("Jan", "Kowalski", "nz12312@zut.edu.pl","32"));

        Map<Integer, List<Student>> groupsOfStudents = new HashMap<>();
        //HashMap różni się od TreeSet implementowaną strukturą danych
        //HashMap to tablca hashy, TreeSet jest drzewem
        //TreeSet gwarantuje, że elementy będą posortowane - wtedy warto jest go użyć
        //w większości przypadków HashMap będzie jednak rozwiązaniem wydajniejszym
        //nie była wymagana żadna inna zmiana w kodzie

        groupsOfStudents.put(32, group32);
        System.out.println("grupa 32:");
        System.out.println(groupsOfStudents.get(32));

        //System.out.println(mkramarczyk.getCourseName());
        //zadanie 3

        List<Product> products = new ArrayList<>();
        try(BufferedReader in = new BufferedReader(new FileReader("produkty.txt"))) {

            String line = in.readLine();

            while ((line = in.readLine()) != null) {
                //System.out.println(line);
                String[] vars = line.split(";");
                Integer id = Integer.parseInt(vars[0]);
                String name = vars[1];
                String category = vars[2];
                Double price = Double.parseDouble(vars[3]);

                products.add(new Product(id, name, category, price));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Map<Integer, Product> idOfProducts = new HashMap<>();
        Map<String, List<Product>> categoryOfProductsMapped = new HashMap<>();
        Set<String> categoryOfProducts = new HashSet<>();

        for (Product p: products){
            idOfProducts.put(p.getId(), p);
            categoryOfProducts.add(p.getCategory());
        }

        for (String cat: categoryOfProducts){
            List<Product> eachCategory = new ArrayList<>();

            for (Product p: products){
                if (p.getCategory().compareTo(cat)==0){
                    eachCategory.add(p);
                }
            }
            categoryOfProductsMapped.put(cat, eachCategory);
        }

        System.out.println(categoryOfProductsMapped.get("słodycze"));

    }
}
