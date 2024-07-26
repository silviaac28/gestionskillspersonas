package com.agencia.persons.infraestructure;

import java.util.Scanner;

import com.agencia.persons.application.CreatePersonUseCase;
import com.agencia.persons.application.DeletePersonUseCase;
import com.agencia.persons.application.UpdatePersonUseCase;
import com.agencia.persons.domain.entity.Person;

public class PersonController {

    private final CreatePersonUseCase createPersonUseCase;
    private final DeletePersonUseCase deletePersonUseCase;
    private final UpdatePersonUseCase updatePersonUseCase;

    public PersonController(CreatePersonUseCase createPersonUseCase, DeletePersonUseCase deletePersonUseCase, UpdatePersonUseCase updatePersonUseCase) {
        this.createPersonUseCase = createPersonUseCase;
        this.deletePersonUseCase = deletePersonUseCase;
        this.updatePersonUseCase = updatePersonUseCase;
    }

    Scanner scanner = new Scanner(System.in);

    public void gestionPerson(){


        while(true){
            System.out.println("1. Registrar persona: ");
            System.out.println("2. Actualizar información de persona: ");
            System.out.println("3. Eliminar persona: ");
            System.out.println("4. Salir: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    createPerson();
                    
                    break;

                case 2:
                    
                    updatePerson();            
    
                    break;

                case 3:

                    deletePerson();

                    break;

                case 4:
                    return;
            
                default:
                    break;
            }
            
        }

    }

    public void createPerson(){
      

            System.out.println("Ingrese el nombre de la persona:");
            String nombre = scanner.nextLine();
            
            System.out.println("Ingrese el apellido de la persona:");
            String apellido = scanner.nextLine();
            
            System.out.print("Ingrese el ID de la ciudad");
            int ciudad = scanner.nextInt();
            scanner.nextLine(); 
            
            System.out.print("Ingrese la direcciòn: ");
            String direccion = scanner.nextLine();
            
            System.out.print("Ingrese la edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Ingrese el correo: ");
            String correo = scanner.nextLine();
            
            System.out.print("Ingrese el ID del gènero: ");
            int generoid = scanner.nextInt();
            scanner.nextLine(); 

            Person person = new Person();
            person.setName(nombre);
            person.setLastname(apellido);
            person.setIdCity(ciudad);
            person.setAddress(direccion);
            person.setAge(edad);
            person.setEmail(correo);
            person.setIdGender(generoid);

            createPersonUseCase.execute(person);
            System.out.println("Persona registrada correctamente. ");
    

        
    }

    public void deletePerson(){
        System.out.println("Ingrese el id para eliminar la persona");
        int id = scanner.nextInt();
        scanner.nextLine();

        deletePersonUseCase.execute(id);

        if(deletePersonUseCase != null){
            System.out.println("Persona eliminado correctamente. ");
        }else{
            System.out.println("No eliminado");
        }
    }

    public void updatePerson(){

            System.out.println("Ingrese el id para actualizar la persona: ");
            int idPersonUpdate = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el nuevo nombre de la persona:");
            String newnombre = scanner.nextLine();
            
            System.out.println("Ingrese el nuevo apellido de la persona:");
            String newapellido = scanner.nextLine();
            
            System.out.print("Ingrese el nuevo ID de la ciudad");
            int newciudad = scanner.nextInt();
            scanner.nextLine(); 
            
            System.out.print("Ingrese la nueva direcciòn: ");
            String newdireccion = scanner.nextLine();
            
            System.out.print("Ingrese la nueva edad: ");
            int newedad = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Ingrese el nuevo correo: ");
            String newcorreo = scanner.nextLine();
            
            System.out.print("Ingrese el nuevo ID del gènero: ");
            int newgeneroid = scanner.nextInt();
            scanner.nextLine(); 

            Person newPerson = new Person();

            newPerson.setId(idPersonUpdate);
            newPerson.setName(newnombre);
            newPerson.setLastname(newapellido);
            newPerson.setIdCity(newciudad);
            newPerson.setAddress(newdireccion);
            newPerson.setAge(newedad);
            newPerson.setEmail(newcorreo);
            newPerson.setIdGender(newgeneroid);

            updatePersonUseCase.execute(newPerson);

    }}


