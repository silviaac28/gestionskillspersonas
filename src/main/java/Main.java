
import java.util.Scanner;




import com.agencia.persons.application.CreatePersonUseCase;
import com.agencia.persons.application.DeletePersonUseCase;
import com.agencia.persons.application.UpdatePersonUseCase;
import com.agencia.persons.infraestructure.PersonController;
import com.agencia.persons.infraestructure.PersonRepository;

import com.agencia.skills.application.CreateSkillUseCase;
import com.agencia.skills.infraestructure.SkillController;
import com.agencia.skills.infraestructure.SkillRepository;




public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    
        PersonRepository personRepository = new PersonRepository();

        CreatePersonUseCase createPersonUseCase = new CreatePersonUseCase(personRepository);
        UpdatePersonUseCase updatePersonUseCase = new UpdatePersonUseCase(personRepository);
        DeletePersonUseCase deletePersonUseCase = new DeletePersonUseCase(personRepository);

        PersonController personController = new PersonController(createPersonUseCase, deletePersonUseCase, updatePersonUseCase);


        SkillRepository skillRepository = new SkillRepository();

        CreateSkillUseCase createSkillUseCase = new CreateSkillUseCase(skillRepository);
       
        SkillController skillController = new SkillController(createSkillUseCase);

        while (true) {
            
            System.out.println("1. Gestion Personas");
            System.out.println("2. Gestion Skills");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                 personController.gestionPerson();
                    

            
                    break;

                case 2:
                   
                    skillController.gestionSkill();
                    break;

                case 3:
                    return;

                    
                
                
                default:

                    System.out.println("Opción inválida");
                    break;

            }
        }
    }
}