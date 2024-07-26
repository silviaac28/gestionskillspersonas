package com.agencia.skills.infraestructure;

import java.util.Scanner;

import com.agencia.skills.application.CreateSkillUseCase;
import com.agencia.skills.domain.entity.Skill;


public class SkillController {

    private final CreateSkillUseCase createSkillUseCase;

    public SkillController(CreateSkillUseCase createSkillUseCase) {
        this.createSkillUseCase = createSkillUseCase;
    }

    
    Scanner scanner = new Scanner(System.in);

    public void gestionSkill(){


        while(true){
            System.out.println("1. Crear Skill: ");
            System.out.println("2. Asignar skill a persona : ");
            System.out.println("4. Salir: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    createSkill();
                    
                    break;

                case 2:
                    
           
    
                    break;


                case 4:
                    return;
            
                default:
                    break;
            }
            
        }

    }

    private void createSkill() {
        System.out.println("Ingrese el nombre del skill:");
        String nombreskill = scanner.nextLine();

        Skill skill = new Skill();
        skill.setName(nombreskill);

        createSkillUseCase.execute(skill);
        System.out.println("Skill creado.");
        
    }

}
